package com.dsmovie.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_score")
public class Score {

	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;
	
	public Score() {		
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}	

	public void setUser(User user) {
		id.setUser(user);
	}
	
}
