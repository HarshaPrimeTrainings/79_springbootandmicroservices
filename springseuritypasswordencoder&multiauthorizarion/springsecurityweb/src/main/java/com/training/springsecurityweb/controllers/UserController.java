package com.training.springsecurityweb.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecurityweb.dao.Role;
import com.training.springsecurityweb.dao.RoleRepository;
import com.training.springsecurityweb.dao.Roles;
import com.training.springsecurityweb.dao.UserInfo;
import com.training.springsecurityweb.dao.UserRepository;
import com.training.springsecurityweb.dto.UserDto;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@Autowired
	RoleRepository rolesRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/save")
	 public UserInfo saveUser(@RequestBody UserDto u) {
		u.setPassword(encoder.encode(u.getPassword()));
		UserInfo user = new UserInfo();
		user.setUname(u.getUname());
		user.setPassword(u.getPassword());
		user.setEmail(u.getEmail());
		
		Set<String> roles = u.getRoles();
		
		Set<Roles> useroles = new HashSet<>();
		roles.stream().forEach(role->{
			Roles userRole =  rolesRepo.findByRole(Role.valueOf(role)).orElseThrow(()->new RuntimeException("Role Not found"));
			useroles.add(userRole);
			
		});
		
		user.setRoles(useroles);
		 return repo.save(user); 
	 }
	
}
