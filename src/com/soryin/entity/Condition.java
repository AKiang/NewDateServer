package com.soryin.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 条件
 * @author soryin
 */
@Entity
@Table(name = "t_Condition")
public class Condition implements Serializable {


	private static final long serialVersionUID = 1634102965385824466L;


	private Set<Fare> fareList;// 费用

	private List<IDType> idTypeList;// 身份证类型
	
	private String name;// 条件内容
	
	private String name_EN;//条件内容_英文
	

	private Long conditionID;

	@Id
	@GeneratedValue
	public Long getConditionID() {
		return conditionID;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "conditionID")
	public Set<Fare> getFareList() {
		return fareList;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "conditionID")
	public List<IDType> getIdTypeList() {
		return idTypeList;
	}

	public String getName() {
		return name;
	}


	public String getName_EN() {
		return name_EN;
	}

	public void setConditionID(Long conditionID) {
		this.conditionID = conditionID;
	}

	public void setFareList(Set<Fare> fareList) {
		this.fareList = fareList;
	}

	public void setIdTypeList(List<IDType> idTypeList) {
		this.idTypeList = idTypeList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName_EN(String name_EN) {
		this.name_EN = name_EN;
	}
}
