package com.flower.friend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.flower.friend.pojo.NoFriend;
/**
 * nofriend数据访问接口
 * @author Administrator
 *
 */
public interface NoFriendDao extends JpaRepository<NoFriend,Long>,JpaSpecificationExecutor<NoFriend>{
	
}
