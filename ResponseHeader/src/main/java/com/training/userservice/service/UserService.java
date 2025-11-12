package com.training.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.training.userservice.dao.User;
import com.training.userservice.exception.UserNotFoundException;

@Service
public class UserService {

	List<User> usersList = new ArrayList<>();
	public UserService() {
		usersList.add(new User(1, "vivek", "hyd", "vivek@gmail.com","1234567"));
		usersList.add(new User(2, "joe", "nyc", "joe@gmail.com","1234567"));
		usersList.add(new User(3, "pheebe", "ohio", "pheebe@gmail.com","1234567"));
		usersList.add(new User(4, "chandler", "cnd", "chandler@gmail.com","1234567"));
		usersList.add(new User(5, "ross", "atlanta", "ross@gmail.com","1234567"));
		usersList.add(new User(6, "monika", "atlanta", "monika@gmail.com","1234567"));
		usersList.add(new User(7, "rachel", "illinoise", "rachel@gmail.com","1234567"));
	}
	
	public List<User> getAllUsers(){
		System.out.println(usersList);
		return usersList;
	}
	
	public User getUserById(Integer uid) {
		return usersList.stream().filter(usr->usr.getUid() == uid).findFirst()
				.orElseThrow(()->new UserNotFoundException("User Not Found with ID : "+uid));
	}
	
	public User saveUser(User user) {
		usersList.add(user);
		return getUserById(user.getUid());
	}
	
	
	public User updateUser(Integer uid,User u) {
		User existing = getUserById(uid);
		existing.setName(u.getName()!=null?u.getName():existing.getName());
		existing.setAddress(u.getAddress()!=null?u.getAddress():existing.getAddress());
		existing.setContact(u.getContact()!=null?u.getContact():existing.getContact());
		return existing;
	}
	
	public String deleteUser(Integer uid) {
		User existing = getUserById(uid);
		usersList.remove(existing);
		return "User Deleted Successfully";
	}
	
}
