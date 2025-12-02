package com.training.userservice.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	private String name;
	private String contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_zip",referencedColumnName = "zip")
	private Adress address;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<Hobbies> hobbie;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Cources> cources;
	

	public List<Cources> getCources() {
		return cources;
	}

	public void setCources(List<Cources> cources) {
		this.cources = cources;
	}

	public List<Hobbies> getHobbie() {
		return hobbie;
	}

	public void setHobbie(List<Hobbies> hobbie) {
		this.hobbie = hobbie;
	}

	public Adress getAddress() {
		return address;
	}

	public void setAddress(Adress address) {
		this.address = address;
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


	
	
	
	
}
