package com.flower.gathering.service;

import com.flower.common.util.IdWorker;
import com.flower.gathering.dao.GatheringDao;
import com.flower.gathering.pojo.Gathering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
 * gathering服务层
 * 
 * @author Administrator
 *
 */
@Service
public class GatheringService {

	@Autowired
	private GatheringDao gatheringDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Gathering> findAll() {
		return gatheringDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Gathering> findSearch(Map whereMap, int page, int size) {
		Specification<Gathering> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return gatheringDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Gathering> findSearch(Map whereMap) {
		Specification<Gathering> specification = createSpecification(whereMap);
		return gatheringDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	@Cacheable(value = "gathering",key = "#id")
	public Gathering findById(String id) {
		return gatheringDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param gathering
	 */
	public void add(Gathering gathering) {
		// gathering.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		gatheringDao.save(gathering);
	}

	/**
	 * 修改
	 * @param gathering
	 */
	@CacheEvict(value="gathering",key="#gathering.id")
	public void update(Gathering gathering) {
		gatheringDao.save(gathering);
	}

	/**
	 * 删除
	 * @param id
	 */
	@CacheEvict(value="gathering",key="#id")
	public void deleteById(String id) {
		gatheringDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Gathering> createSpecification(Map searchMap) {

		return new Specification<Gathering>() {

			@Override
			public Predicate toPredicate(Root<Gathering> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // id
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
