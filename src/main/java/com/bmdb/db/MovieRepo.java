package com.bmdb.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Credit;
import com.bmdb.business.Movie;

public interface MovieRepo extends CrudRepository<Movie, Integer> {
	
	//get all movies by rating
	List<Movie> findAllByRating(String rating);

	List<Movie> findAllByYearGreaterThanEqual(int year);
}
