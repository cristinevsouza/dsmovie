package com.dsmovie.dsmovie.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.entities.Movie;
import com.dsmovie.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	private MovieRepository movieRepo;
	
	public MovieService(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}


	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		
		Page<Movie> movies = movieRepo.findAll(pageable);
		Page<MovieDTO> page = movies.map(x -> new MovieDTO(x));
		
		return page;	
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		
		Movie movie = movieRepo.findById(id).get();
		MovieDTO movieDto = new MovieDTO(movie);
		
		return movieDto;	
	}
}
