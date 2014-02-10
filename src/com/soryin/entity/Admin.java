package com.soryin.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



/**
 * 超级管理员
 * @author soryin
 */
@Entity
public class Admin implements Serializable{


	private static final long serialVersionUID = -6145235954959778963L;

	private Long id;
	
	private String account;

	private String password;

	private int rank;//权限

	public String getAccount() {
		return account;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public int getRank() {
		return rank;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
}
