package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 身份证类型
 *  @author soryin
 */
@Entity
public class IDType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3431693061914528255L;

	private Long idTypeID;
	
	private String type;//类型名称
	
	private String type_EN;//类型名称

	@Id
	@GeneratedValue
	public Long getIdTypeID() {
		return idTypeID;
	}

	public String getType() {
		return type;
	}

	public String getType_EN() {
		return type_EN;
	}

	public void setIdTypeID(Long idTypeID) {
		this.idTypeID = idTypeID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType_EN(String type_EN) {
		this.type_EN = type_EN;
	}
}
