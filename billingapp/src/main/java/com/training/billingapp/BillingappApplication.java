package com.training.billingapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BillingappApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(BillingappApplication.class, args);
		while(true) {
			System.out.println("Select The Number to Order");
			MenuDetails menu = ioc.getBean(MenuDetails.class);
			BillingService bs = ioc.getBean(BillingService.class);
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
