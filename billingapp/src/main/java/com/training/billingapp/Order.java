package com.training.billingapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

	@Autowired
	private MenuDetails menu;
	
	@Autowired
	private BillingService bs;
	
	public void placeOrder() {
		while(true) {
			System.out.println("Select The Number to Order");
			bs.showMenu();
			Scanner input = new Scanner(System.in);
			
			switch (input.nextInt()) {
			case 1: {
				 List breakfast = menu.getBreakfast();
				 System.out.println("select Item");
				 ItemDetails selecteditem = (ItemDetails) breakfast.get(input.nextInt()-1);
				 bs.addItem(selecteditem);
				 bs.checkout();
				 if(input.nextInt()==2) {
					 System.out.println("Total Bill: "+ bs.totalBill());
					 return;
				 }
				break;
			}
			case 2:{
				List lunch = menu.getLunch();
				System.out.println("select Item");
				 ItemDetails selecteditem = (ItemDetails) lunch.get(input.nextInt()-1);
				 bs.addItem(selecteditem);
				 bs.checkout();
				 if(input.nextInt()==2) {
					 System.out.println("Total Bill: "+ bs.totalBill());
					 return;
				 }
				break;
			}
			case 3:{
				List beverages = menu.getBeaverages();
				ItemDetails selecteditem = (ItemDetails) beverages.get(input.nextInt()-1);
				 bs.addItem(selecteditem);
				 bs.checkout();
				 if(input.nextInt()==2) {
					 System.out.println("Total Bill: "+ bs.totalBill());
					 return;
				 }
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + input);
			}
			
		}
	}
	
	
}
