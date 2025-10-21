package com.training.springcoredemo.utills;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Product {


	
	private Integer pid;
	private String pname;
	private Integer price;
	
	public Product() {
		System.out.println("Prduct Intilized");
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
	
}
