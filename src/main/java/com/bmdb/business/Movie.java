package com.bmdb.business;

import javax.persistence.*;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int year;
	private String rating;
	private String director;

	public Movie(int id, String title, String rating, int year, String director) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.year = year;
		this.director = director;
	}
	public Movie(String title, String rating, int year, String director) {
		super();
		this.title = title;
		this.rating = rating;
		this.year = year;
		this.director = director;
	}
	
	public Movie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int newYear) {
		this.year = newYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return 	"\n"+
				"Movie id: "+id+"\n"+
				"Title: "+title+", Rating: "+rating+"\n"+
				"Year: "+year+", Director: "+director;
				
	}

}
