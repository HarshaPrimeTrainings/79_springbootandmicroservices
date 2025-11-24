package com.training.multidatabaseservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.multidatabaseservice.h2.Student;
import com.training.multidatabaseservice.h2.StudentRepository;

@RestController
@RequestMapping("/std")
public class StudentController {

	
	@Autowired
	StudentRepository strepo;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student stdnt) {
		return strepo.save(stdnt);
	}
	
	
}
