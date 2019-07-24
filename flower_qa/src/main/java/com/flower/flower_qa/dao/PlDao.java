package com.flower.flower_qa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.flower.flower_qa.pojo.Pl;
/**
 * pl数据访问接口
 * @author Administrator
 *
 */
public interface PlDao extends JpaRepository<Pl,String>,JpaSpecificationExecutor<Pl>{
	
}
