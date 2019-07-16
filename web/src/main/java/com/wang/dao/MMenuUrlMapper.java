package com.wang.dao;

import com.wang.entity.MMenuUrl;

public interface MMenuUrlMapper {
    int deleteByPrimaryKey(String id);

    int insert(MMenuUrl record);

    int insertSelective(MMenuUrl record);

    MMenuUrl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MMenuUrl record);

    int updateByPrimaryKey(MMenuUrl record);
}