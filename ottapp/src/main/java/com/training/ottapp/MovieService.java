package com.training.ottapp;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface MovieService {

	public List<Movie> showMovies();
	
}
