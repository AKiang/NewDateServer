package com.soryin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4639585990327373690L;

	private Long id;
	private String account;// 账号
	private String name;// 昵称
	private String password;// 密码
	private String address;// 地址
	private String phone;// 电话
	private String sex;// 性别
	private int age;// 年龄
	private int rank;// 权限
	private Date registerTime;// 注册时间
	private Date lastLoginTime;// 最后一次登录时间
	private String state;// 用户状态
	private String verified;// 是否是认证用户
	private String minImg;// 小头像
	private String maxImg;// 大头像
	private List<Event> events;
	private GroupManager groupManager;
	private long level;//级别
	private Date syncTime;//最后同步时间
	
	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	//-------------------------
	//-----以下为’用户设置‘数据----
	//-------------------------
	private String language;//语言

	private String fontSize;//文字大小设置

	private String dateFromat;//时间格式

	private String associatedInfo;//关联信息设置

	private String hotspot;//热点信息标签
	
	private Set<UserAccessRecord> userAccessRecord;//用户访问记录表

	@JSONField(serialize=false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userInfo")
	public Set<UserAccessRecord> getUserAccessRecord() {
		return userAccessRecord;
	}

	public void setUserAccessRecord(Set<UserAccessRecord> userAccessRecord) {
		this.userAccessRecord = userAccessRecord;
	}

	public String getAccount() {
		return account;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public String getAssociatedInfo() {
		return associatedInfo;
	}

	public String getDateFromat() {
		return dateFromat;
	}

	@JSONField(serialize=false)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userInfo",fetch=FetchType.LAZY)
	public List<Event> getEvents() {
		return events;
	}

	public String getFontSize() {
		return fontSize;
	}
	
	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupMangerID")
	public GroupManager getGroupManager() {
		return groupManager;
	}
	public String getHotspot() {
		return hotspot;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public String getLanguage() {
		return language;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public long getLevel() {
		return level;
	}
	
	public String getMaxImg() {
		return maxImg;
	}

	public String getMinImg() {
		return minImg;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public int getRank() {
		return rank;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public String getSex() {
		return sex;
	}

	public String getState() {
		return state;
	}

	public String getVerified() {
		return verified;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAssociatedInfo(String associatedInfo) {
		this.associatedInfo = associatedInfo;
	}

	public void setDateFromat(String dateFromat) {
		this.dateFromat = dateFromat;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}

	public void setHotspot(String hotspot) {
		this.hotspot = hotspot;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public void setMaxImg(String maxImg) {
		this.maxImg = maxImg;
	}

	public void setMinImg(String minImg) {
		this.minImg = minImg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}
}
