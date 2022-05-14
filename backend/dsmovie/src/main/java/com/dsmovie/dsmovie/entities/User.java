package com.dsmovie.dsmovie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String email;

	public User() {
		
	}

	public User(Long id, String email) {
		this.id = id;
		this.email = email;
	}		
}


