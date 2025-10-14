package com.training.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springcoredemo.utills.Product;
import com.training.springcoredemo.utills.User;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(SpringcoredemoApplication.class, args);
		
		Product p =  ioc.getBean(Product.class);
		p.setPid(1);
		p.setPname("electronics");
		p.setPrice(10);
		System.out.println(p);
		
		User u = ioc.getBean(User.class);
		u.setUid(1);
		u.setUsername("vivek");
		u.setAddress("Hyd");
		System.out.println(u);
		
	}

}
