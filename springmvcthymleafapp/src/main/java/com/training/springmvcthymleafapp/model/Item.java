package com.training.springmvcthymleafapp.model;

import java.util.UUID;

public class Item {

	private Integer id;
	private String ItemName;
	private Integer price;
	
	public Item() {
		
	}
	
	public Item(Integer id, String itemName, Integer price) {
		super();
		this.id = id;
		ItemName = itemName;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
