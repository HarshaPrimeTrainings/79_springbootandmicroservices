package com.training.userservice.dto;

import java.util.List;

public class UserDto {

	private Integer uid;
	private String name;
	private String contact;
	private List<OrderDto> orders;
	
	public UserDto() {
		
	}
	
	
	
	public UserDto(Integer uid, String name, String contact, List<OrderDto> orders) {
		this.uid = uid;
		this.name = name;
		this.contact = contact;
		this.orders = orders;
	}



	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	
}
