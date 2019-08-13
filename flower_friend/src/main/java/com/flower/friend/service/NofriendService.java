package com.flower.friend.service;

import com.flower.common.util.IdWorker;
import com.flower.friend.dao.NoFriendDao;
import com.flower.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * nofriend服务层
 * 
 * @author Administrator
 *
 */
@Service
public class NofriendService {

	@Autowired
	private NoFriendDao nofriendDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<NoFriend> findAll() {
		return nofriendDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<NoFriend> findSearch(Map whereMap, int page, int size) {
		Specification<NoFriend> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return nofriendDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<NoFriend> findSearch(Map whereMap) {
		Specification<NoFriend> specification = createSpecification(whereMap);
		return nofriendDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public NoFriend findById(Long id) {
		return nofriendDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param nofriend
	 */
	public void add(NoFriend nofriend) {
		// nofriend.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		nofriendDao.save(nofriend);
	}

	/**
	 * 修改
	 * @param nofriend
	 */
	public void update(NoFriend nofriend) {
		nofriendDao.save(nofriend);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id) {
		nofriendDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<NoFriend> createSpecification(Map searchMap) {

		return new Specification<NoFriend>() {

			@Override
			public Predicate toPredicate(Root<NoFriend> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // userid
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // friendid
                if (searchMap.get("friendid")!=null && !"".equals(searchMap.get("friendid"))) {
                	predicateList.add(cb.like(root.get("friendid").as(String.class), "%"+(String)searchMap.get("friendid")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
