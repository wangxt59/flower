package com.wang.dao;

import com.wang.entity.MWorker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface MWorkerMapper {
    int deleteByPrimaryKey(String workerId);

    int insert(MWorker record);

    int insertSelective(MWorker record);

    MWorker selectByPrimaryKey(String workerId);
    List<MWorker> selectByMap(Map map);

    int updateByPrimaryKeySelective(MWorker record);

    int updateByPrimaryKey(MWorker record);
}