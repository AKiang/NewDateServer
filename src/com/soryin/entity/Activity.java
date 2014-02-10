package com.soryin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 小活动
 * 
 * @author soryin
 */
@Entity
@AttributeOverride(column = @Column(name = "activityID"), name = "id")
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8955207537621304977L;

	@Id
	@GeneratedValue
	public Long getActivityID() {
		return activityID;
	}

	public void setActivityID(Long activityID) {
		this.activityID = activityID;
	}

	private Long activityID;
	
	private String name;// 小活动名
	
	private String description;// 描述

	private ActivityType activityType;// 小活动类型

	private Date timeStart;// 开始时间

	private Date timeEnd;// 结束时间

	private Set<Condition> conditionSet;// 条件

	private Set<Steps> stepsList;// 步奏

	private Set<Constrain> constrainList;// 限制

	private Set<Location> locations;

	private Set<com.soryin.entity.Entity> entityList;

	private Event event;

	private String name_EN;// 小活动名_英文
	
	private String description_EN;// 描述_英文

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "activityTypeID")
	public ActivityType getActivityType() {
		return activityType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "activityID")
	public Set<Condition> getConditionSet() {
		return conditionSet;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "activityID")
	public Set<Constrain> getConstrainList() {
		return constrainList;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	
	public String getDescription_EN() {
		return description_EN;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "activityID")
	public Set<com.soryin.entity.Entity> getEntityList() {
		return entityList;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "eventID")
	public Event getEvent() {
		return event;
	}

	@OneToMany(mappedBy = "activity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Location> getLocations() {
		return locations;
	}
	
	public String getName() {
		return name;
	}

	public String getName_EN() {
		return name_EN;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "activityID")
	public Set<Steps> getStepsList() {
		return stepsList;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public void setConditionSet(Set<Condition> conditionSet) {
		this.conditionSet = conditionSet;
	}

	public void setConstrainList(Set<Constrain> constrainList) {
		this.constrainList = constrainList;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription_EN(String description_EN) {
		this.description_EN = description_EN;
	}

	public void setEntityList(Set<com.soryin.entity.Entity> entityList) {
		this.entityList = entityList;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName_EN(String name_EN) {
		this.name_EN = name_EN;
	}

	public void setStepsList(Set<Steps> stepsList) {
		this.stepsList = stepsList;
	}


	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}


}
