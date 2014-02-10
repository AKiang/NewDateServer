package com.soryin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class GroupManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1874714722978749504L;

	private Long id;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String groupName;

	private List<UserInfo> userInfos;

	private List<ManagerAction> managerActions;

	public String getGroupName() {
		return groupName;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Group_Action", joinColumns = @JoinColumn(name = "groupID"), inverseJoinColumns = @JoinColumn(name = "actionID"))
	public List<ManagerAction> getManagerActions() {
		return managerActions;
	}

	@OneToMany(mappedBy = "groupManager", fetch = FetchType.LAZY)
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setManagerActions(List<ManagerAction> managerActions) {
		this.managerActions = managerActions;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
}
