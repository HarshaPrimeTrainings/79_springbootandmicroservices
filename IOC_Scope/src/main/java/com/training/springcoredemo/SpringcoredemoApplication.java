package com.training.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demoutil.User;
import com.training.springcoredemo.utills.Product;

@SpringBootApplication
@ComponentScan(basePackages = "com.training.springcoredemo,com.demoutil")
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(SpringcoredemoApplication.class, args);
		
		Product p =  ioc.getBean(Product.class);
		p.setPid(1);
		p.setPname("electronics");
		p.setPrice(10);
		
		Product p1 = ioc.getBean(Product.class);
		p1.setPid(2);
		p1.setPname("statinary");
		p1.setPrice(5);
		
		System.out.println(p);
		System.out.println(p1);
		
		
		
		
		/*
		 * User u = ioc.getBean(User.class); u.setUid(1); u.setUsername("vivek");
		 * u.setAddress("Hyd"); System.out.println(u);
		 */
		
	}

}
