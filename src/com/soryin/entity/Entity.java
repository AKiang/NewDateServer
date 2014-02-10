package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * 组织/人物
 * 
 * @author soryin
 * */
@javax.persistence.Entity
public class Entity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4401035884240787609L;

	/**
	 * 
	 */
	private Long entityID;

	private String description;// 描述

	private String wechat;// 微信
	
	private String weibo;// 微博
	
	private String tqq;// 腾讯微博

	private String name;

	private int personal;// 1属于个人，2标志组织,0表示为空

	private String name_EN;// 组织名，英文

	private String description_EN;

	private String tel;						// 电话

	private String address;				// 地址

	private String email;					// 邮箱

	private String website;				// 网址

	private String address_EN;//地址，英文
	
	public String getAddress() {
		return address;
	}
	
	public String getAddress_EN() {
		return address_EN;
	}

	public String getDescription() {
		return description;
	}
	
	public String getDescription_EN() {
		return description_EN;
	}

	public String getEmail() {
		return email;
	}

	@Id
	@GeneratedValue
	public Long getEntityID() {
		return entityID;
	}

	public String getName() {
		return name;
	}

	public String getName_EN() {
		return name_EN;
	}

	public int getPersonal() {
		return personal;
	}

	public String getTel() {
		return tel;
	}

	public String getTqq() {
		return tqq;
	}

	public String getWebsite() {
		return website;
	}

	public String getWechat() {
		return wechat;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddress_EN(String address_EN) {
		this.address_EN = address_EN;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription_EN(String description_EN) {
		this.description_EN = description_EN;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEntityID(Long entityID) {
		this.entityID = entityID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName_EN(String name_EN) {
		this.name_EN = name_EN;
	}

	public void setPersonal(int personal) {
		this.personal = personal;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setTqq(String tqq) {
		this.tqq = tqq;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}
