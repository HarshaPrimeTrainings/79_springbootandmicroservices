package com.training.springcoredemo.utills;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Qualifier("mrng")
@Component
public class MorningGreet implements Greet{

	@Override
	public void saygreet() {
		System.out.println("Hi There! GoodMorning");
		
	}

}
