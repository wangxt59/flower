package com.wang.dao;

import com.wang.entity.MRole;

public interface MRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(MRole record);

    int insertSelective(MRole record);

    MRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(MRole record);

    int updateByPrimaryKey(MRole record);
}