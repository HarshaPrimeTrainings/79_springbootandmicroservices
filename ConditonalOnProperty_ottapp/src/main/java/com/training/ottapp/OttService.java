package com.training.ottapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OttService {
	
	@Autowired
	private MovieService service;
	
	
	public List<Movie> playMovies(){
		return service.showMovies();
	}
	
	

}
