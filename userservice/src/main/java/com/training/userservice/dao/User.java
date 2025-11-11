package com.training.userservice.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private Integer uid;
	private String name;
	private String address;
	private String contact;
	
	@JsonIgnore
	private String password;

	public User(Integer uid, String name, String address, String contact, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", address=" + address + ", contact=" + contact + ", password="
				+ password + "]";
	}
	
	
	
	
	
}
