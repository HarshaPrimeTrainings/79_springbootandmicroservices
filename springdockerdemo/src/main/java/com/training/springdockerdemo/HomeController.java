package com.training.springdockerdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String greet() {
		return "<h1>Spring Spring Service1</h1>";
	}
	
}
