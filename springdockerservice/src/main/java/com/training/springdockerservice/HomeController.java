package com.training.springdockerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String greet() {
		return "<h1>Spring Service2</h1>";
	}
	
}
