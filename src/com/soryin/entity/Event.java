package com.soryin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 活动
 * 
 * @author soryin
 * */
@Entity
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8143060324816511296L;

	/**
	 * 
	 */

	private String eventID;

	private String name; // 活动名

	private String picture; // 图片路径

	private String description; // 描述

	private Set<Activity> activityList; // 小活动列表

	private CountInfo countInfo; // 数量统计

	private UserInfo userInfo; // 用户信息

	private Date releaseTime;// 活动时间

	private String name_EN;//活动名_英文
	
	private String description_EN;//活动描述_英文
	
	private String updateContent;//更新了的内容
	
	private String updateContent_EN;//更新内容_english
	
	
	public String getUpdateContent_EN() {
		return updateContent_EN;
	}

	public void setUpdateContent_EN(String updateContent_EN) {
		this.updateContent_EN = updateContent_EN;
	}

	private Date updateTime;//更新了的时间
	
	private Date createTime;//创建的时间

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "event")
	public Set<Activity> getActivityList() {
		return activityList;
	}
	
	
	public String getUpdateContent() {
		return updateContent;
	}
	
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

	public Date getUpdateTime() {
		updateTime=new Date();//获取当前服务器时间
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public CountInfo getCountInfo() {
		return countInfo;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDescription_EN() {
		return description_EN;
	}

	@Id
	public String getEventID() {
		return eventID;
	}

	public String getName() {
		return name;
	}

	public String getName_EN() {
		return name_EN;
	}
	
	public String getPicture() {
		return picture;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}
	
	@ManyToOne
	@JoinColumn(name = "userInfoID")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setActivityList(Set<Activity> activityList) {
		this.activityList = activityList;
	}

	public void setCountInfo(CountInfo countInfo) {
		this.countInfo = countInfo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription_EN(String description_EN) {
		this.description_EN = description_EN;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName_EN(String name_EN) {
		this.name_EN = name_EN;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


}
