package com.training.springcoredemo.utills;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Qualifier("evng")
@Component
public class EveningGreet implements Greet{
	@Override
	public void saygreet() {
		System.out.println("HI Therer GoodEvening");
		
	}
}
