package com.training.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.userservice.dao.User;
import com.training.userservice.dao.UserRepository;
import com.training.userservice.exception.UserNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;

	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
	}
	
	public User getUserById(Integer uid) {
		return repo.findById(uid).orElseThrow(()-> new UserNotFoundException("User not found with ID "+uid));
	}
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	
	public User updateUser(Integer uid,User u) {
		User existing = getUserById(uid);
		existing.setName(u.getName()!=null?u.getName():existing.getName());
		existing.setAddress(u.getAddress()!=null?u.getAddress():existing.getAddress());
		existing.setContact(u.getContact()!=null?u.getContact():existing.getContact());
		return repo.save(existing);
	}
	
	public String deleteUser(Integer uid) {
		repo.deleteById(uid);
		return "User Deleted Successfully";
	}
	
}
