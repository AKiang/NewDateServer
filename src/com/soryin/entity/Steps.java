package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * 步骤
 *  @author soryin
 */
@Entity
public class Steps implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6124442225839220357L;

	private Long stepsID;
	
	private String name;

	private String description;//描述

	private String name_EN;//步骤名称_英文

	private String description_EN;//描述_英文
	
	public String getDescription() {
		return description;
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

	@Id
	@GeneratedValue
	public Long getStepsID() {
		return stepsID;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public void setStepsID(Long stepsID) {
		this.stepsID = stepsID;
	}
}
