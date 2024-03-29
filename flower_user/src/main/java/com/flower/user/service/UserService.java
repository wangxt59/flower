package com.flower.user.service;

import com.flower.common.util.IdWorker;
import com.flower.user.dao.UserDao;
import com.flower.user.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * user服务层
 *
 * @author Administrator
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    BCryptPasswordEncoder encoder;


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 更新关注数
     *
     * @param x
     */
    @Transactional
    public void incFollowcount(String userid, int x) {
        userDao.incFollowcount(userid, x);
    }


    /**
     * 更新粉丝数
     *
     * @param x
     */
    @Transactional
    public void incFanscount(String userid, int x) {
        userDao.incFanscount(userid, x);
    }


    /**
     * 根据手机号和密码查询用户
     *
     * @param mobile
     * @param password
     * @return
     */
    public User findByMobileAndPassword(String mobile, String password) {
        User user = userDao.findByPhone(mobile);
        if (user != null && encoder.matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }


    /**
     * 增加
     *
     * @param user 用户
     * @param code 用户填写的验证码
     */
    public void add(User user, String code) {
        //判断验证码是否正确
        String syscode = (String) redisTemplate.opsForValue().get("smscode_" + user.getPhone());
        //提取系统正确的验证码
        if (syscode == null) {
            throw new RuntimeException("请点击获取短信验证码");
        }
        if (!syscode.equals(code)) {
            throw new RuntimeException("验证码输入不正确");
        }
        user.setId("" + idWorker.nextId());
        user.setFollowcount(0);//关注数
        user.setFanscount(0);//粉丝数
        user.setOnline(0);//在线时长
        user.setCreateDate(new Date());//注册日期
        user.setUpdateDate(new Date());//更新日期
        user.setLastDate(new Date());//最后登陆日期
        //密码加密
        String newpassword = encoder.encode(user.getPassword());//加密后的密码
        user.setPassword(newpassword);
        userDao.save(user);
    }


    /**
     * 发送短信验证码
     *
     * @param mobile 手机号
     */
    public void sendSms(String mobile) {
        //1.生成6位短信验证码
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);//随机生成
        if (code < min) {
            code = code + min;
        }
        System.out.println(mobile + "收到验证码是：" + code);
        //2.将验证码放入redis
        redisTemplate.opsForValue().set("smscode_" + mobile, code + "", 5, TimeUnit.MINUTES);//五分钟过期
        //3.将验证码和手机号发动到rabbitMQ中
        Map<String, String> map = new HashMap();
        map.put("mobile", mobile);
        map.put("code", code + "");
        rabbitTemplate.convertAndSend("flower.message", map);
    }

    /**
     * 查询全部列表
     *
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<User> findSearch(Map whereMap, int page, int size) {
        Specification<User> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userDao.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<User> findSearch(Map whereMap) {
        Specification<User> specification = createSpecification(whereMap);
        return userDao.findAll(specification);
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    /**
     * 增加
     *
     * @param user
     */
    public void add(User user) {
        // user.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
        userDao.save(user);
    }

    /**
     * 修改
     *
     * @param user
     */
    public void update(User user) {
        userDao.save(user);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<User> createSpecification(Map searchMap) {

        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // 微信openid
                if (searchMap.get("openId") != null && !"".equals(searchMap.get("openId"))) {
                    predicateList.add(cb.like(root.get("openId").as(String.class), "%" + (String) searchMap.get("openId") + "%"));
                }
                // 用户名
                if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                    predicateList.add(cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
                }
                // 账号
                if (searchMap.get("account") != null && !"".equals(searchMap.get("account"))) {
                    predicateList.add(cb.like(root.get("account").as(String.class), "%" + (String) searchMap.get("account") + "%"));
                }
                // 密码
                if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                    predicateList.add(cb.like(root.get("password").as(String.class), "%" + (String) searchMap.get("password") + "%"));
                }
                // 邮箱
                if (searchMap.get("email") != null && !"".equals(searchMap.get("email"))) {
                    predicateList.add(cb.like(root.get("email").as(String.class), "%" + (String) searchMap.get("email") + "%"));
                }
                // 手机
                if (searchMap.get("phone") != null && !"".equals(searchMap.get("phone"))) {
                    predicateList.add(cb.like(root.get("phone").as(String.class), "%" + (String) searchMap.get("phone") + "%"));
                }
                // 送货住址
                if (searchMap.get("address") != null && !"".equals(searchMap.get("address"))) {
                    predicateList.add(cb.like(root.get("address").as(String.class), "%" + (String) searchMap.get("address") + "%"));
                }
                // 省市县
                if (searchMap.get("province") != null && !"".equals(searchMap.get("province"))) {
                    predicateList.add(cb.like(root.get("province").as(String.class), "%" + (String) searchMap.get("province") + "%"));
                }
                // 余额
                if (searchMap.get("balance") != null && !"".equals(searchMap.get("balance"))) {
                    predicateList.add(cb.like(root.get("balance").as(String.class), "%" + (String) searchMap.get("balance") + "%"));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

    }

}
