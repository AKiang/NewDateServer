package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * 限制
 *  @author soryin
 * */
@Entity
public class Constrain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8420978435533048114L;

	private Long constrainID;
	
	private String name;// 限制名称

	private String descripetion;// 描述

	private String name_EN;

	private String description_EN;//描述_英文

	@Id
	@GeneratedValue
	public Long getConstrainID() {
		return constrainID;
	}

	public String getDescripetion() {
		return descripetion;
	}
	
	public String getDescription_EN() {
		return description_EN;
	}

	public String getName() {
		return name;
	}

	public String getName_EN() {
		return name_EN;
	}

	public void setConstrainID(Long constrainID) {
		this.constrainID = constrainID;
	}

	public void setDescripetion(String descripetion) {
		this.descripetion = descripetion;
	}

	public void setDescription_EN(String description_EN) {
		this.description_EN = description_EN;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setName_EN(String name_EN) {
		this.name_EN = name_EN;
	}

}
