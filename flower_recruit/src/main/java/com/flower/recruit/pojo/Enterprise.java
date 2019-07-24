package com.flower.recruit.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * enterprise实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_enterprise")
public class Enterprise implements Serializable{

	@Id
	private String id;//id
	@Column(columnDefinition="COMMENT '企业名称'")
	private String name;//企业名称
	@Column(columnDefinition="COMMENT '企业简介'")
	private String summary;//企业简介
	@Column(columnDefinition="COMMENT '企业地址'")
	private String address;//企业地址
	@Column(columnDefinition="COMMENT '标签列表'")
	private String labels;//标签列表
	@Column(columnDefinition="COMMENT '企业位置坐标 经度，纬度'")
	private String coordinate;//企业位置坐标 经度，纬度
	@Column(columnDefinition="COMMENT '是否热门 0：非热门 1：热门'")
	private String ishot;//是否热门 0：非热门 1：热门
	@Column
	private String logo;//logo
	@Column(columnDefinition="COMMENT '职位数'")
	private Integer jobcount;//职位数
	@Column
	private String url;//url
	@Column
	private java.util.Date createTime;//create_time
	@Column
	private java.util.Date updateTime;//update_time


	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getLabels() {
		return labels;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getIshot() {
		return ishot;
	}
	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getJobcount() {
		return jobcount;
	}
	public void setJobcount(Integer jobcount) {
		this.jobcount = jobcount;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}


	
}
