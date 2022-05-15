package com.dsmovie.dsmovie.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsmovie.dsmovie.dto.MovieDTO;
import com.dsmovie.dsmovie.dto.ScoreDTO;
import  com.dsmovie.dsmovie.services.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	private ScoreService scoreService;
	
	public ScoreController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO score) {
		MovieDTO dto = 	scoreService.saveScore(score);
		return dto;
	}
}
