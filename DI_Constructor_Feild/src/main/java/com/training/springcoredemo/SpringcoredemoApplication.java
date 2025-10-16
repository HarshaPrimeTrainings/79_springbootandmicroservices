package com.training.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demoutil.User;
import com.training.springcoredemo.utills.Order;
import com.training.springcoredemo.utills.Product;

@SpringBootApplication
@ComponentScan(basePackages = "com.training.springcoredemo,com.demoutil")
public class SpringcoredemoApplication {

    private final Order order;

    SpringcoredemoApplication(Order order) {
        this.order = order;
    }

	public static void main(String[] args) {
		
		ApplicationContext ioc = SpringApplication.run(SpringcoredemoApplication.class, args);
		
		Product p =  ioc.getBean(Product.class);
		p.setPid(1);
		p.setPname("electronics");
		p.setPrice(10);
		
		Order ord = ioc.getBean(Order.class);
		ord.setOid(7);
		ord.setStatus("delivered");
		
		System.out.println(ord);
		
	}

}
