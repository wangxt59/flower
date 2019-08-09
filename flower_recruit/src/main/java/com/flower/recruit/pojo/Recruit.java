package com.flower.recruit.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * recruit实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_recruit")
public class Recruit implements Serializable{

	@Id
	private String id;//id
	@Column(columnDefinition="COMMENT '招聘职位'")
	private String jobname;//招聘职位
	@Column(columnDefinition="COMMENT '薪资范围'")
	private String salary;//薪资范围
	@Column(columnDefinition="COMMENT '经验要求'")
	private String condition;//经验要求
	@Column(columnDefinition="COMMENT '学历要求'")
	private String education;//学历要求
	@Column(columnDefinition="COMMENT '任职方式'")
	private String type;//任职方式
	@Column(columnDefinition="COMMENT '办公地址'")
	private String address;//办公地址
	@Column(columnDefinition="COMMENT '企业ID'")
	private String eid;//企业ID
	@Column
	private java.util.Date updatetime;//updatetime
	@Column
	private java.util.Date createtime;//发布日期
	@Column(columnDefinition="COMMENT '状态0：关闭 1:开启 2：推荐'")
	private String state;//状态0：关闭 1:开启 2：推荐
	@Column(columnDefinition="COMMENT '原网址'")
	private String url;//原网址
	@Column(columnDefinition="COMMENT '标签'")
	private String label;//标签
	@Column(columnDefinition="COMMENT '职位描述'")
	private String content1;//职位描述
	@Column(columnDefinition="COMMENT '职位要求！'")
	private String content2;//职位要求

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}

	public java.util.Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}


	
}
