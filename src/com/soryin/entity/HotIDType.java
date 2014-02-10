package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 2013-08-06<br>
 * 热门证件类型(用来做表Activity类型单选项展示)
 * 
 * @author soryin
 * */

@Entity
public class HotIDType implements Serializable {


	private static final long serialVersionUID = -5245569445879238306L;

	@Id
	@GeneratedValue
	private Long hotID;

	private long frequency;
	
	private String name;

	public long getFrequency() {
		return frequency;
	}

	public String getName() {
		return name;
	}

	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

	public void setName(String name) {
		this.name = name;
	}
}
