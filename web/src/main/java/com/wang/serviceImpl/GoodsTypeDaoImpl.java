package com.wang.serviceImpl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author cheng
 * @ClassName: GoodsTypeDaoImpl
 * @Description: 模拟数据访问实现类
 * @date 2017年10月13日 上午10:54:32
 */
@Repository
@CacheConfig(cacheNames = "test")
public class GoodsTypeDaoImpl {

    @Cacheable
    public String save(String typeId) {
        System.out.println("save()执行了=============");
        return "模拟数据库保存";
    }

    @CachePut
    public String update(String typeId) {
        System.out.println("update()执行了=============");
        return "模拟数据库更新";
    }

    @CacheEvict
    public String delete(String typeId) {
        System.out.println("delete()执行了=============");
        return "模拟数据库删除";
    }

    @Cacheable
    public String select(String typeId) {
        System.out.println("select()执行了=============");
        return "模拟数据库查询";
    }
}
