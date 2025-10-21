package com.demoutil;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	private Integer uid;
	private String username;
	private String address;
	
	public User() {
		System.out.println("User Intilized");
		
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", address=" + address + "]";
	}
	
	
	

}
