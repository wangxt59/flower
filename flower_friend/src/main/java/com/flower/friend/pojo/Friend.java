package com.flower.friend.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * friend实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_friend")
@IdClass(Friend.class)
public class Friend implements Serializable{

	@Id
	private Long id;//id
	@Id
	private String userid;//userid
	@Id
	private String friendid;//friendid
	private String islike;//0：单向喜欢 1：互相喜欢

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFriendid() {
		return friendid;
	}
	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	public String getIslike() {
		return islike;
	}
	public void setIslike(String islike) {
		this.islike = islike;
	}


	
}
