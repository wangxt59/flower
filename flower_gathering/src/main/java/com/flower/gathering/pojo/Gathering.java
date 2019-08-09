package com.flower.gathering.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * gathering实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_gathering")
public class Gathering implements Serializable{

	@Id
	private String id;//id


	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	
}
