package com.flower.qa.dao;

import com.flower.qa.pojo.Pl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * pl数据访问接口
 * @author Administrator
 *
 */
public interface PlDao extends JpaRepository<Pl,String>,JpaSpecificationExecutor<Pl>{
	
}
