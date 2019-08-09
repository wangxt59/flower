package com.flower.spit.service;

import com.flower.common.util.IdWorker;
import com.flower.spit.dao.SpitDao;
import com.flower.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * spit服务层
 * 
 * @author Administrator
 *
 */
@Service
public class SpitService {

	@Autowired
	private SpitDao spitDao;
	
	@Autowired
	private IdWorker idWorker;

	@Autowired
	private MongoTemplate mongoTemplate;


	/**
	 * 点赞
	 * @param id
	 */
	public void updateThumbup(String id){
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update=new Update();
		update.inc("thumbup",1);
		mongoTemplate.updateFirst(query,update,"spit");
	}



	/**
	 * 根据上级ID查询吐槽列表
	 * @param parentid
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Spit> findByParentid(String parentid,int page, int size){
		PageRequest pageRequest = PageRequest.of(page-1, size);
		return spitDao.findByParentid(parentid, pageRequest);
	}



	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Spit> findAll() {
		return spitDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Spit> findSearch(Map whereMap, int page, int size) {
		Specification<Spit> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return spitDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Spit> findSearch(Map whereMap) {
		Specification<Spit> specification = createSpecification(whereMap);
		return spitDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param Id
	 * @return
	 */
	public Spit findById(String Id) {
		return spitDao.findById(Id).get();
	}


	/**
	 * 发布吐槽（或吐槽评论）
	 * @param spit
	 */
	public void add(Spit spit){
		spit.setId( idWorker.nextId()+"" );
		spit.setPublishtime(new Date());//发布日期
		spit.setVisits(0);//浏览量
		spit.setShare(0);//分享数
		spit.setThumbup(0);//点赞数
		spit.setComment(0);//回复数
		spit.setState("1");//状态
		if(spit.getParentid()!=null && !"".equals(spit.getParentid())){// 如果存在上级ID,评论
			Query query=new Query();
			query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
			Update update=new Update();
			update.inc("comment",1);
			mongoTemplate.updateFirst(query,update,"spit");
		}
		spitDao.save(spit);
	}
	/**
	 * 增加
	 * @param spit
	 */
//	public void add(Spit spit) {
		// spit.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
//		spitDao.save(spit);
//	}

	/**
	 * 修改
	 * @param spit
	 */
	public void update(Spit spit) {
		spitDao.save(spit);
	}

	/**
	 * 删除
	 * @param Id
	 */
	public void deleteById(String Id) {
		spitDao.deleteById(Id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Spit> createSpecification(Map searchMap) {

		return new Specification<Spit>() {

			@Override
			public Predicate toPredicate(Root<Spit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // _id
                if (searchMap.get("Id")!=null && !"".equals(searchMap.get("Id"))) {
                	predicateList.add(cb.like(root.get("Id").as(String.class), "%"+(String)searchMap.get("Id")+"%"));
                }
                // 吐槽内容
                if (searchMap.get("content")!=null && !"".equals(searchMap.get("content"))) {
                	predicateList.add(cb.like(root.get("content").as(String.class), "%"+(String)searchMap.get("content")+"%"));
                }
                // 发布人ID
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 发布人昵称
                if (searchMap.get("nickname")!=null && !"".equals(searchMap.get("nickname"))) {
                	predicateList.add(cb.like(root.get("nickname").as(String.class), "%"+(String)searchMap.get("nickname")+"%"));
                }
                // 是否可见
                if (searchMap.get("state")!=null && !"".equals(searchMap.get("state"))) {
                	predicateList.add(cb.like(root.get("state").as(String.class), "%"+(String)searchMap.get("state")+"%"));
                }
                // 上级ID
                if (searchMap.get("parentid")!=null && !"".equals(searchMap.get("parentid"))) {
                	predicateList.add(cb.like(root.get("parentid").as(String.class), "%"+(String)searchMap.get("parentid")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
