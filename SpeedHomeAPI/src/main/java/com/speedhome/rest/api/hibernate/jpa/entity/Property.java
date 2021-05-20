package com.speedhome.rest.api.hibernate.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String houseFlatNumber;
	private String address;
	private String facing;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseFlatNumber() {
		return houseFlatNumber;
	}
	public void setHouseFlatNumber(String houseFlatNumber) {
		this.houseFlatNumber = houseFlatNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFacing() {
		return facing;
	}
	public void setFacing(String facing) {
		this.facing = facing;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
