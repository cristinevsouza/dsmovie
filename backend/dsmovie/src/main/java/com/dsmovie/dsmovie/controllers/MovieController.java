package com.dsmovie.dsmovie.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable) {
		return movieService.findAll(pageable);	
	}
	
	@GetMapping("/{id}")
	public MovieDTO findById(@PathVariable Long id) {
		return movieService.findById(id);	
	}
}
