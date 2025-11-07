package com.training.userservice.dao;

public class User {

	private Integer uid;
	private String name;
	private String address;
	private String contact;
	
	public User(Integer uid, String name, String address, String contact) {
		super();
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.contact = contact;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	
}
