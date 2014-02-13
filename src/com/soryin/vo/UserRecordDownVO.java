package com.soryin.vo;

import java.io.Serializable;
import java.util.Set;

import com.soryin.entity.UserAccessRecord;

public class UserRecordDownVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<UserAccessRecord> accessRecords;
	private String syncTime;
	public Set<UserAccessRecord> getAccessRecords() {
		return accessRecords;
	}
	public void setAccessRecords(Set<UserAccessRecord> accessRecords) {
		this.accessRecords = accessRecords;
	}
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
}
