package com.soryin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ManagerAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1890645145682692230L;

	private Long id;

	private String actionName;


	private List<GroupManager> groupManages;

	private String url;

	public String getActionName() {
		return actionName;
	}
	@ManyToMany(mappedBy = "managerActions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<GroupManager> getGroupManages() {
		return groupManages;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public void setGroupManages(List<GroupManager> groupManages) {
		this.groupManages = groupManages;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public ManagerAction(String actionName, String url) {//构造方法
		this.actionName = actionName;
		this.url = url;
	}
}
