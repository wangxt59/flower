package com.flower.spit.dao;

import com.flower.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * spit数据访问接口
 * @author Administrator
 *
 */
public interface SpitDao extends MongoRepository<Spit,String>,JpaRepository<Spit,String>,JpaSpecificationExecutor<Spit>{






    /**
     * 根据上级ID查询吐槽列表（分页）
     * @param parentid
     * @param pageable
     * @return
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);

}
