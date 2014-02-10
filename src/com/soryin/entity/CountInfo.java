package com.soryin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * 统计
 * @author soryin
 */
@Entity
public class CountInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -909596738746899143L;

	/**
	 * 
	 */
	private Long id;
	
	private int conditionCount;					//条件统计

	private int constrinCount;						//限制统计

	private int stepsCount;							//步奏统计

	private String personalCount;				//个人统计

	private String organization;					//组织统计

	private int activityCount;						//小活动数量统计

	private Event event;								//Event关联

	private Date timeStart;							//计算整个event的开始时间

	private Date timeEnd;							//计算整个event的结束时间
	
	private Date createTime;						//在SQL中创建的时间
	
	private Date updateTime;						//活动最新的更新时间
	
	private Date releaseTime;						//活动发布时间
	
	private String promulgator;						//发布者-----------登陆账户的昵称，不过是被静态化到数据库中
	
	private String eventColor;						//每个event的颜色（用于App前端颜色）----根据用户传入的eventImg来计算
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getPromulgator() {
		return promulgator;
	}

	public void setPromulgator(String promulgator) {
		this.promulgator = promulgator;
	}

	public String getEventColor() {
		return eventColor;
	}

	public void setEventColor(String eventColor) {
		this.eventColor = eventColor;
	}

	public int getActivityCount() {
		return activityCount;
	}

	public int getConditionCount() {
		return conditionCount;
	}

	public int getConstrinCount() {
		return constrinCount;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="eventID")
	public Event getEvent() {
		return event;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getOrganization() {
		return organization;
	}

	public String getPersonalCount() {
		return personalCount;
	}

	public int getStepsCount() {
		return stepsCount;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setActivityCount(int activityCount) {
		this.activityCount = activityCount;
	}

	public void setConditionCount(int conditionCount) {
		this.conditionCount = conditionCount;
	}
	
	public void setConstrinCount(int constrinCount) {
		this.constrinCount = constrinCount;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public void setPersonalCount(String personalCount) {
		this.personalCount = personalCount;
	}
	public void setStepsCount(int stepsCount) {
		this.stepsCount = stepsCount;
	}
	
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
		
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
}
