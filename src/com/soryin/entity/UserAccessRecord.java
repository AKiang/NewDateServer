package com.soryin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class UserAccessRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String eventKey;
	private Date createDate;//记录在数据库的创建时间
	private Date accessDate;//记录的访问时间
	private UserInfo userInfo;
	@ManyToOne
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Date getAccessDate() {
		return accessDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getEventKey() {
		return eventKey;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public void setId(long id) {
		this.id = id;
	}
}
