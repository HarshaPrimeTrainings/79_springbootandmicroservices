package com.training.springcoredemo.utills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {
	
	private Integer oid;
	
	private String status;
	
	
	private Product product;
	
	public Order() {
		
	}
	@Autowired
	public Order(Product product) {
		this.product = product;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", status=" + status + ", product=" + product + "]";
	}
	
	

}
