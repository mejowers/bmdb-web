package com.bmdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Genre;
import com.bmdb.db.GenreRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/genres")

public class GenreController {
	@Autowired
	private GenreRepo genreRepo;

	@GetMapping("/")
	public Iterable<Genre> getAll() {
		return genreRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Genre> get(@PathVariable int id) {
		return genreRepo.findById(id);
	}

	@PostMapping("/")
	public Genre add(@RequestBody Genre genre) {
		return genreRepo.save(genre);
	}

	@PutMapping("/")
	public Genre update(@RequestBody Genre genre) {
		return genreRepo.save(genre);
	}

	@DeleteMapping("/{id}")
	public Optional<Genre> delete(@PathVariable int id) {
		Optional<Genre> genre = genreRepo.findById(id);
		if (genre.isPresent()) {
			try {
				genreRepo.deleteById(id);
			} catch (DataIntegrityViolationException dive) {
				// catch dive when movie exists as fk on another table
				System.err.println(dive.getRootCause().getMessage());
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Foreign Key Constraint Issue - Genre id: " + id + " " + "is referred to eslewhere");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exception caught during genre delete.");
			}
		} else {
			System.err.println("Genre delete error - no genre found for id:" + id);
		}
		return genre;
	}

}
