package com.soryin.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *小活动类型 
 * @author soryin
 */
@Entity
public class ActivityType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510593464451972671L;
	
	@Id
	@GeneratedValue
	private Long activityTypeID;
	
	private String type;//类型名称

	private String type_EN;//类型名称_英文

	public Long getActivityTypeID() {
		return activityTypeID;
	}
	
	public String getType() {
		return type;
	}

	public String getType_EN() {
		return type_EN;
	}

	public void setActivityTypeID(Long activityTypeID) {
		this.activityTypeID = activityTypeID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType_EN(String type_EN) {
		this.type_EN = type_EN;
	}
}
