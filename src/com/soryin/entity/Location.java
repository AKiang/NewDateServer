package com.soryin.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * 地点
 *  @author soryin
 */
@Entity
public class Location implements Serializable{

	
	private static final long serialVersionUID = 1099019756993237996L;

	private Long locationID;
	
	private String city;//城市

	private String address;//地址

	private String GPS;
	
	private String landmark;//参照物
	
	private String building;//建筑

	private String street;//街道

	private String room;//房间

	private Activity activity;

	private String city_EN;//城市名，英文

	private String address_EN;//地址,英文

	private String landmark_EN;//参照物，英文

	private String building_EN;//建筑物_英文

	private String street_EN;//街道_英文

	private String room_EN;//房间,英文

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="activityID")
	public Activity getActivity() {
		return activity;
	}
	
	public String getAddress() {
		return address;
	}

	public String getBuilding() {
		return building;
	}

	public String getBuilding_EN() {
		return building_EN;
	}

	public String getCity() {
		return city;
	}

	public String getCity_EN() {
		return city_EN;
	}

	public String getGPS() {
		return GPS;
	}

	public String getLandmark() {
		return landmark;
	}
	
	public String getLandmark_EN() {
		return landmark_EN;
	}

	@Id
	@GeneratedValue
	public Long getLocationID() {
		return locationID;
	}

	public String getRoom() {
		return room;
	}

	public String getRoom_EN() {
		return room_EN;
	}

	public String getStreet() {
		return street;
	}
	
	public String getStreet_EN() {
		return street_EN;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public void setBuilding(String building) {
		this.building = building;
	}
	
	public void setBuilding_EN(String building_EN) {
		this.building_EN = building_EN;
	}
	
	public String getAddress_EN() {
		return address_EN;
	}

	public void setAddress_EN(String address_EN) {
		this.address_EN = address_EN;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void setCity_EN(String city_EN) {
		this.city_EN = city_EN;
	}
	
	public void setGPS(String gPS) {
		GPS = gPS;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	
	public void setLandmark_EN(String landmark_EN) {
		this.landmark_EN = landmark_EN;
	}
	
	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}
	
	public void setRoom(String room) {
		this.room = room;
	}
	
	
	public void setRoom_EN(String room_EN) {
		this.room_EN = room_EN;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setStreet_EN(String street_EN) {
		this.street_EN = street_EN;
	}
	
}
