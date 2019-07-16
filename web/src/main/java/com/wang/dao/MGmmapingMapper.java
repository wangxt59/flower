package com.wang.dao;

import com.wang.entity.MGmmaping;

public interface MGmmapingMapper {
    int deleteByPrimaryKey(String gmId);

    int insert(MGmmaping record);

    int insertSelective(MGmmaping record);

    MGmmaping selectByPrimaryKey(String gmId);

    int updateByPrimaryKeySelective(MGmmaping record);

    int updateByPrimaryKey(MGmmaping record);
}