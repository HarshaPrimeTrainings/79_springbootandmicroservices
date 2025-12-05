package com.training.springsecurityweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecurityweb.dao.UserInfo;
import com.training.springsecurityweb.dao.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@PostMapping("/save")
	 public UserInfo saveUser(@RequestBody UserInfo u) {
		 return repo.save(u); 
	 }
	
}
