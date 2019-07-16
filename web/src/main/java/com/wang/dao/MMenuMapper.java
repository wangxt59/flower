package com.wang.dao;

import com.wang.entity.MMenu;

public interface MMenuMapper {
    int deleteByPrimaryKey(String mId);

    int insert(MMenu record);

    int insertSelective(MMenu record);

    MMenu selectByPrimaryKey(String mId);

    int updateByPrimaryKeySelective(MMenu record);

    int updateByPrimaryKey(MMenu record);
}