package com.flower.friend.service;

import com.flower.common.util.IdWorker;
import com.flower.friend.client.UserClient;
import com.flower.friend.dao.FriendDao;
import com.flower.friend.dao.NoFriendDao;
import com.flower.friend.pojo.Friend;
import com.flower.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * friend服务层
 *
 * @author Administrator
 */
@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private NoFriendDao noFriendDao;

    @Autowired
    private UserClient userClient;




    /**
     * 删除好友
     *
     * @param userid
     * @param friendid
     */
    @Transactional
    public void deleteFriend(String userid, String friendid) {
        friendDao.deleteFriend(userid, friendid);
        friendDao.updateLike(friendid, userid, "0");
        userClient.incFollowcount(userid,-1);//减少自己的关注数
        userClient.incFanscount(friendid,-1);//减少对方的粉丝数
        addNoFriend(userid, friendid);//向不喜欢表中添加记录
    }


    /**
     * 向不喜欢列表中添加记录
     *
     * @param userid
     * @param friendid
     */
    public void addNoFriend(String userid, String friendid) {
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }


    @Transactional
    public int addFriend(String userid, String friendid) {
        //判断如果用户已经添加了这个好友，则不进行任何操作,返回0
        if (friendDao.selectCount(userid, friendid) > 0) {
            return 0;
        }
        //向喜欢表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);
        userClient.incFollowcount(userid,1);//增加自己的关注数
        userClient.incFanscount(friendid,1);//增加对方的粉丝数
        //判断对方是否喜欢你，如果喜欢，将islike设置为1
        if (friendDao.selectCount(friendid, userid) > 0) {
            friendDao.updateLike(userid, friendid, "1");
            friendDao.updateLike(friendid, userid, "1");
        }
        return 1;
    }


    /**
     * 查询全部列表
     *
     * @return
     */
    public List<Friend> findAll() {
        return friendDao.findAll();
    }


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Friend> findSearch(Map whereMap, int page, int size) {
        Specification<Friend> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return friendDao.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<Friend> findSearch(Map whereMap) {
        Specification<Friend> specification = createSpecification(whereMap);
        return friendDao.findAll(specification);
    }

    /**
     * 根据ID查询实体
     *
     * @param id
     * @return
     */
    public Friend findById(Long id) {
        return friendDao.findById(id).get();
    }

    /**
     * 增加
     *
     * @param friend
     */
    public void add(Friend friend) {
        // friend.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
        friendDao.save(friend);
    }

    /**
     * 修改
     *
     * @param friend
     */
    public void update(Friend friend) {
        friendDao.save(friend);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(Long id) {
        friendDao.deleteById(id);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<Friend> createSpecification(Map searchMap) {

        return new Specification<Friend>() {

            @Override
            public Predicate toPredicate(Root<Friend> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // userid
                if (searchMap.get("userid") != null && !"".equals(searchMap.get("userid"))) {
                    predicateList.add(cb.like(root.get("userid").as(String.class), "%" + (String) searchMap.get("userid") + "%"));
                }
                // friendid
                if (searchMap.get("friendid") != null && !"".equals(searchMap.get("friendid"))) {
                    predicateList.add(cb.like(root.get("friendid").as(String.class), "%" + (String) searchMap.get("friendid") + "%"));
                }
                // 0：单向喜欢 1：互相喜欢
                if (searchMap.get("islike") != null && !"".equals(searchMap.get("islike"))) {
                    predicateList.add(cb.like(root.get("islike").as(String.class), "%" + (String) searchMap.get("islike") + "%"));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));

            }
        };

    }

}
