package com.speedhome.rest.api.bean;

public class PropertyRequest {
	
	private String houseFlatNumber;
	private String address;
	private String facing;
	private String status;
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
	
	@Override
	public String toString() {
		return "PropertyRequest [houseFlatNumber=" + houseFlatNumber + ", address=" + address + ", facing=" + facing
				+ ", status=" + status + "]";
	}
	
	

}
