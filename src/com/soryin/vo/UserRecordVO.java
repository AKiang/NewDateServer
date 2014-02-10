package com.soryin.vo;

import java.io.Serializable;
import java.util.Date;

public class UserRecordVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eventKey;
	private Date accessDate;//记录的访问时间
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public Date getAccessDate() {
		return accessDate;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
}
