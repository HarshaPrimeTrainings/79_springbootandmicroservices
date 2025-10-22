package com.training.ottapp;

public class Movie {
	
	private String name;
	private String zoner;
	private Integer rating;
	
	
	
	public Movie(String name, String zoner, Integer rating) {
		this.name = name;
		this.zoner = zoner;
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZoner() {
		return zoner;
	}
	public void setZoner(String zoner) {
		this.zoner = zoner;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", zoner=" + zoner + ", rating=" + rating + "]";
	}
	
	
	

}
