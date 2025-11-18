package com.training.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.Order;
import com.training.orderservice.dao.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository repo;
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return (List<Order>) repo.findAll();
	}
	
	
	@PostMapping("/order")
	public Order saveOrder(@RequestBody Order ord) {
		return repo.save(ord);
	}
	
	@GetMapping("/order/{oid}")
	public Order getOrderById(@PathVariable Integer oid) {
		return repo.findById(oid).orElseThrow(()->new RuntimeException("Ordr not found "+ oid));
	}
	
	
}
