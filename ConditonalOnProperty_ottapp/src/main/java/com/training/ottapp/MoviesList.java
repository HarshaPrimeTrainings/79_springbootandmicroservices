package com.training.ottapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MoviesList {

	public List<Movie> movies;
	
	public List<Movie> regularMovies(){
		return List.of(new Movie("Interstellar", "scifie", 5),
				new Movie("Beast&Beuty", "Love", 4),
				new Movie("Twilight", "mixed", 5),
				new Movie("spiderman", "action", 3));
	}
	
	public List<Movie> primeMovies(){
		List<Movie> primeMovies = new ArrayList<>();
		List<Movie> primemoveList = List.of(new Movie("Avengers", "action", 5),
				new Movie("titanic", "Love", 4),
				new Movie("avatar", "fantacy", 5),
				new Movie("MIB", "action", 3));
		
		primeMovies.addAll(regularMovies());
		primeMovies.addAll(primemoveList);
		
		return primeMovies;
		
	}
}
