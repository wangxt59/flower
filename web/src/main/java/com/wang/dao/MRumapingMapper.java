package com.wang.dao;

import com.wang.entity.MRumaping;

public interface MRumapingMapper {
    int deleteByPrimaryKey(String ruId);

    int insert(MRumaping record);

    int insertSelective(MRumaping record);

    MRumaping selectByPrimaryKey(String ruId);

    int updateByPrimaryKeySelective(MRumaping record);

    int updateByPrimaryKey(MRumaping record);
}