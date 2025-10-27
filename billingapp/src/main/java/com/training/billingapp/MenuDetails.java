package com.training.billingapp;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class MenuDetails {

	public List<ItemDetails> getBreakfast(){
		 List breakfast= List.of(new ItemDetails("IDLI",40),new ItemDetails("DOSA",50),new ItemDetails("WADA",70));
		 IntStream.range(0, breakfast.size())
		 .forEach(i->System.out.println((i+1)+"."+breakfast.get(i)));
		 return breakfast;
	
	}
	
	public List<ItemDetails> getLunch(){
		 List lunch = List.of(new ItemDetails("THALI",140),new ItemDetails("RICECOBO",100));
		 IntStream.range(0, lunch.size())
		 .forEach(i->System.out.println((i+1)+"."+lunch.get(i)));
		 return lunch;
		 
	}
	
	public List<ItemDetails> getBeaverages(){
		List beverages =  List.of(new ItemDetails("COFFER",30),new ItemDetails("TEA",20));
		IntStream.range(0, beverages.size())
		 .forEach(i->System.out.println((i+1)+"."+beverages.get(i)));
		return beverages;
	}
	
}
