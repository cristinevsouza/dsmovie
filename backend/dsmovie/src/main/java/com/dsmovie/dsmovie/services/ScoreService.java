package com.dsmovie.dsmovie.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.dto.ScoreDTO;
import com.dsmovie.dsmovie.entities.Movie;
import com.dsmovie.dsmovie.entities.Score;
import com.dsmovie.dsmovie.entities.User;
import com.dsmovie.dsmovie.repositories.MovieRepository;
import com.dsmovie.dsmovie.repositories.ScoreRepository;
import com.dsmovie.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	private MovieRepository movieRepo;
	private UserRepository userRepo;
	private ScoreRepository scoreRepo;
	
	public ScoreService(MovieRepository movieRepo, UserRepository userRepo, ScoreRepository scoreRepo) {
		this.movieRepo = movieRepo;
		this.userRepo = userRepo;
		this.scoreRepo = scoreRepo;
	}
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDto) {
		
		User user = userRepo.findByEmail(scoreDto.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(scoreDto.getEmail());
			user = userRepo.saveAndFlush(user);
		}
		
		Movie movie = movieRepo.findById(scoreDto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		
		score = scoreRepo.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepo.save(movie);
		
		return new MovieDTO(movie);
	}
}
