package com.wang.dao;

import com.wang.entity.MRgmaping;

public interface MRgmapingMapper {
    int deleteByPrimaryKey(String rgId);

    int insert(MRgmaping record);

    int insertSelective(MRgmaping record);

    MRgmaping selectByPrimaryKey(String rgId);

    int updateByPrimaryKeySelective(MRgmaping record);

    int updateByPrimaryKey(MRgmaping record);
}