package com.training.ottapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OttappApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(OttappApplication.class, args);
		OttService ott = ioc.getBean(OttService.class);
		System.out.println(ott.playMovies());
		
	}

}
