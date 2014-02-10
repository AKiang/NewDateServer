package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 费用
 *  @author soryin
 */
@Entity
public class Fare implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1109852081682482994L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue
	private Long fareID;
	
	private String method;//支付方式
	
	private double price;//价格

	public Long getFareID() {
		return fareID;
	}

	public String getMethod() {
		return method;
	}

	public double getPrice() {
		return price;
	}

	public void setFareID(Long fareID) {
		this.fareID = fareID;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
