package com.training.billingapp;

public class ItemDetails {

	public String name;
	public Integer ItemPrice;
	
	public ItemDetails(String name, Integer itemPrice) {
		super();
		this.name = name;
		ItemPrice = itemPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		ItemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "name=" + name + ", ItemPrice=" + ItemPrice;
	}
	
	
	
}
