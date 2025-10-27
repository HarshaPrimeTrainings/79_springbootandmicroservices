package com.training.billingapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BillingService {

	private Integer totalBill = 0;
	
	private List<ItemDetails> selectedItems = new ArrayList<>();
	
	public List<ItemDetails> addItem(ItemDetails item){
		selectedItems.add(item);
		return selectedItems;
	}
	
	public Integer totalBill() {
		System.out.println("=====Total Bill =======");
		selectedItems.forEach(System.out::println);
		return selectedItems.stream().mapToInt(ItemDetails::getItemPrice).sum();
		
	}
	
	public void showMenu() {
		System.out.println("1. BreakFast");
		System.out.println("2. Lunch");
		System.out.println("3. Bevarages");
	}
	public void checkout() {
		System.out.println("1. SelectMore");
		if(selectedItems.size()>0) {
			System.out.println("2. Chckout");
		}
	}
	
	
}
