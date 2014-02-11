package com.soryin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donghai
 *
 */
public class UserRequestParameter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserActionRquestType taskType;
	private String uid;
	private String levelNum;
	private UserSettingVO setting;
	private Date syncTime;
	private String userName;
	private String recordContent;
	public String getRecordContent() {
		return recordContent;
	}
	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}
	public String getLevelNum() {
		return levelNum;
	}
	public UserSettingVO getSetting() {
		return setting;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public UserActionRquestType getTaskType() {
		return taskType;
	}
	public String getUid() {
		return uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
	} 
	public void setSetting(UserSettingVO setting) {
		this.setting = setting;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public void setTaskType(UserActionRquestType taskType) {
		this.taskType = taskType;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
