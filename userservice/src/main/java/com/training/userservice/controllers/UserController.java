package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;

@RestController
@RequestMapping("/user")
public class UserController {

	List<User> usersList = new ArrayList<>();
	public UserController() {
		usersList.add(new User(1, "vivek", "hyd", "vivek@gmail.com"));
		usersList.add(new User(2, "joe", "nyc", "joe@gmail.com"));
		usersList.add(new User(3, "pheebe", "ohio", "pheebe@gmail.com"));
		usersList.add(new User(4, "chandler", "cnd", "chandler@gmail.com"));
		usersList.add(new User(5, "ross", "atlanta", "ross@gmail.com"));
		usersList.add(new User(6, "monika", "atlanta", "monika@gmail.com"));
		usersList.add(new User(7, "rachel", "illinoise", "rachel@gmail.com"));
	}
	
	@RequestMapping("/all")
	public List<User> getAllUsers(){
		return usersList;
	}
	
	@RequestMapping("/{uid}")
	public User getUserById(@PathVariable Integer uid) {
		return usersList.stream().filter(usr->usr.getUid() == uid).findFirst().orElse(null);
	}
	
	@RequestMapping("/req")
	public User getUserByIdReq(@RequestParam Integer uid) {
		return usersList.stream().filter(usr->usr.getUid() == uid).findFirst().orElse(null);
	}

}
