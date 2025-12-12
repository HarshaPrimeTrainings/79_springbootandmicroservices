package com.training.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


	@GetMapping("/user")
	public String greet() {
		return "Hello User";
	}
	
	
}
