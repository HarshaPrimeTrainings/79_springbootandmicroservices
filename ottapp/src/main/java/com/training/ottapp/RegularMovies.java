package com.training.ottapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "prime.subscribe",havingValue = "false")
@Component
public class RegularMovies implements MovieService{

	@Autowired
	MoviesList mvlist;
	
	@Override
	public List<Movie> showMovies() {
		return mvlist.regularMovies();
	}
	
	

}
