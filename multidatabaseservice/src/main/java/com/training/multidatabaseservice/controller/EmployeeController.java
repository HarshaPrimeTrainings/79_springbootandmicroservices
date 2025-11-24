package com.training.multidatabaseservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.multidatabaseservice.mysql.Employee;
import com.training.multidatabaseservice.mysql.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee emp) {
		return repo.save(emp);
	}
	
}
