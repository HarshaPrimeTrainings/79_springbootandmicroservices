package com.training.userservice.dto;

public class OrderDto {

	private Integer oid;
	private String catageary;
	private String status;
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getCatageary() {
		return catageary;
	}
	public void setCatageary(String catageary) {
		this.catageary = catageary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
