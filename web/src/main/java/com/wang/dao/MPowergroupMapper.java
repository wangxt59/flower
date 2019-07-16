package com.wang.dao;

import com.wang.entity.MPowergroup;

public interface MPowergroupMapper {
    int deleteByPrimaryKey(String pgroupId);

    int insert(MPowergroup record);

    int insertSelective(MPowergroup record);

    MPowergroup selectByPrimaryKey(String pgroupId);

    int updateByPrimaryKeySelective(MPowergroup record);

    int updateByPrimaryKey(MPowergroup record);
}