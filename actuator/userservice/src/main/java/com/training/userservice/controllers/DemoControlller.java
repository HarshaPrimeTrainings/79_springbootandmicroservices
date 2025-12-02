package com.training.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoControlller {

	@GetMapping("/hello")
	public String greet() {
		return "Iam from DemoControlller";
	}
}
