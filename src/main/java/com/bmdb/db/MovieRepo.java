package com.bmdb.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Movie;

public interface MovieRepo extends CrudRepository<Movie, Integer> {

}
