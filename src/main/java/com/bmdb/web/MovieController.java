package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Credit;
import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")

public class MovieController {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@GetMapping("/")
	public Iterable<Movie> getAll() {
		return movieRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Movie> get(@PathVariable int id) {
		return movieRepo.findById(id);
	}
	
	@PostMapping("/")
	public Movie add(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}
	
	@PutMapping("/")
	public Movie update(@RequestBody Movie movie) {
		return movieRepo.save(movie);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Movie> delete(@PathVariable int id) {
		Optional<Movie> movie = movieRepo.findById(id);
		if (movie.isPresent()) {
			try {
		movieRepo.deleteById(id);
			}
			catch (DataIntegrityViolationException dive) {
				//catch dive when movie exists as fk on another table
				System.err.println(dive.getRootCause().getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Foreign Key Constraint Issue - Movie id: "+id+" "
								+ "is referred to eslewhere");
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception caught during movie delete.");
			}
	}
		else {
			System.err.println("Movie delete error - no movie found for id:"+id);
		}
		return movie;
}
	@GetMapping("/{rating}")
	public Iterable<Movie> getAllByRating(@PathVariable String rating) {
//		Optional<Movie> movie = movieRepo.findById(id);
		return movieRepo.findAllByRating(rating);
	}
	
}
