package com.bmdb.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Genre;

public interface GenreRepo extends CrudRepository<Genre, Integer> {
	
	
	}
