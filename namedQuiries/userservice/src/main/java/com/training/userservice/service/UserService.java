package com.training.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public List<User> getUserByPage(Integer pageSize,Integer pageNumber){
		Pageable pg = PageRequest.of(pageNumber, pageSize);
		Page<User> userPage = repo.findAll(pg);
		return userPage.toList();
	}
	
	
	public List<User> getUsersBySort(String sortcol,String sorttype){
		
		if(sorttype.equals("desc")) {
			return repo.findAll(Sort.by(sortcol).descending());
		}
		return repo.findAll(Sort.by(sortcol));
	}
	
	
	public User getUserById(Integer uid) {
		return repo.findById(uid).orElseThrow(()-> new UserNotFoundException("User not found with ID "+uid));
	}
	
	public User getUserbyName(String name) {
		return repo.findByName(name).orElseThrow(()-> new UserNotFoundException("User not found with Name "+name));
	}
	
	public List<User> getUserbyaddr(String addr) {
		return repo.findByAddress(addr);
	}
	
	public Integer getCountByAddr(String addr) {
		return repo.getCountByAddress(addr);
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
