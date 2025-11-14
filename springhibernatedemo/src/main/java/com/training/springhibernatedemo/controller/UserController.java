package com.training.springhibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springhibernatedemo.dao.User;
import com.training.springhibernatedemo.dao.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao dao;

	@PostMapping("/save")
	public String saveUser(@RequestBody User usr) {
		return dao.saveUser(usr);
	}
	
	@GetMapping("/user/{uid}")
	public User getUserById(@PathVariable Integer uid) {
		return dao.getUserById(uid);
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return dao.getusers();
	}
	
	@DeleteMapping("/user/{uid}")
	public String deleteUser(@PathVariable Integer uid) {
		return dao.deleteUser(uid);
	}
	
	
}
