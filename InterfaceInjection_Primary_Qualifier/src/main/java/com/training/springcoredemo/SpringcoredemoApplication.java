package com.training.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demoutil.User;
import com.training.springcoredemo.utills.Order;
import com.training.springcoredemo.utills.Product;
import com.training.springcoredemo.utills.Welocome;

@SpringBootApplication
@ComponentScan(basePackages = "com.training.springcoredemo,com.demoutil")
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(SpringcoredemoApplication.class, args);
		Welocome w = ioc.getBean(Welocome.class);
		
		w.display();
		
	}

}
