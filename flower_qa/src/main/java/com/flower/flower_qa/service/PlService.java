package com.flower.flower_qa.service;

import com.flower.common.util.IdWorker;
import com.flower.flower_qa.dao.PlDao;
import com.flower.flower_qa.pojo.Pl;
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
 * pl服务层
 * 
 * @author Administrator
 *
 */
@Service
public class PlService {

	@Autowired
	private PlDao plDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Pl> findAll() {
		return plDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Pl> findSearch(Map whereMap, int page, int size) {
		Specification<Pl> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return plDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Pl> findSearch(Map whereMap) {
		Specification<Pl> specification = createSpecification(whereMap);
		return plDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param problemid
	 * @return
	 */
	public Pl findById(String problemid) {
		return plDao.findById(problemid).get();
	}

	/**
	 * 增加
	 * @param pl
	 */
	public void add(Pl pl) {
		// pl.setProblemid( idWorker.nextId()+"" ); 雪花分布式ID生成器
		plDao.save(pl);
	}

	/**
	 * 修改
	 * @param pl
	 */
	public void update(Pl pl) {
		plDao.save(pl);
	}

	/**
	 * 删除
	 * @param problemid
	 */
	public void deleteById(String problemid) {
		plDao.deleteById(problemid);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Pl> createSpecification(Map searchMap) {

		return new Specification<Pl>() {

			@Override
			public Predicate toPredicate(Root<Pl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 问题ID
                if (searchMap.get("problemid")!=null && !"".equals(searchMap.get("problemid"))) {
                	predicateList.add(cb.like(root.get("problemid").as(String.class), "%"+(String)searchMap.get("problemid")+"%"));
                }
                // 标签ID
                if (searchMap.get("labelid")!=null && !"".equals(searchMap.get("labelid"))) {
                	predicateList.add(cb.like(root.get("labelid").as(String.class), "%"+(String)searchMap.get("labelid")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
