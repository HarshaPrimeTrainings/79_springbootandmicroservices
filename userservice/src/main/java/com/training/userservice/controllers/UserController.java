package com.training.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;
import com.training.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	

	public UserController() {
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(service.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable Integer uid) {
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}
	
	@GetMapping("/req")
	public ResponseEntity<User> getUserByIdReq(@RequestParam Integer uid) {
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User u) {
		return new ResponseEntity<User>(service.saveUser(u),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable Integer uid,@RequestBody User u) {
		return new ResponseEntity<User>(service.updateUser(uid, u),HttpStatus.CREATED);
	}
	
	@PatchMapping("/semiupdate/{uid}")
	public ResponseEntity<User> updateUserproperty(@PathVariable Integer uid,@RequestBody User u) {
		return new ResponseEntity<User>(service.updateUser(uid, u),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		return new ResponseEntity<String>(service.deleteUser(id),HttpStatus.ACCEPTED);
	}
	
	
}
