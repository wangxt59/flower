package com.flower.user.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * user实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private String id;//主键
	@Column
	private String openId;//微信openid
	@Column
	private String name;//用户名
	@Column
	private String account;//账号
	@Column
	private String password;//密码

	@Column
	private String Avatar;//头像
	@Column
	private String nickname;//昵称
	@Column
	private String email;//邮箱
	@Column
	private String phone;//手机
	@Column
	private Integer sex;//性别: 1:男  2:女  3:不确定
	@Column
	private String address;//送货住址
	@Column
	private String province;//省市县
	@Column
	private String balance;//余额
	@Column
	private Double point;//当前总积分
	@Column
	private Integer state;//状态 0: 正常  1:锁定 2:待激活
	@Column
	private java.util.Date createDate;//创建日期
	@Column
	private java.util.Date updateDate;//更新日期
	@Column
	private java.util.Date LastDate;//更新日期
	@Column
	private Integer   followcount;//关注数
	@Column
	private Integer  fanscount;//粉丝数
	@Column
	private Integer  online;//在线时长


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getLastDate() {
		return LastDate;
	}

	public void setLastDate(Date lastDate) {
		LastDate = lastDate;
	}

	public Integer getFollowcount() {
		return followcount;
	}

	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}

	public Integer getFanscount() {
		return fanscount;
	}

	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}
}
