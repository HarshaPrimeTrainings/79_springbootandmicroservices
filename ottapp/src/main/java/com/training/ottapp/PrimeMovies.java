package com.training.ottapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "prime.subscribe",havingValue = "true")
@Component
public class PrimeMovies implements MovieService{

	@Autowired
	MoviesList mvl;
	
	@Override
	public List<Movie> showMovies() {
		return mvl.primeMovies();
	}

	
}
