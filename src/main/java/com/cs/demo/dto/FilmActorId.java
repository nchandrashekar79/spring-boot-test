package com.cs.demo.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FilmActorId implements Serializable {
	
	@Column(name = "actor_id", nullable = false)
	short actorId;
	
	@Column(name = "film_id", nullable = false)
	short filmId;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(short actorId) {
		this.actorId = actorId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(short filmId) {
		this.filmId = filmId;
	}

	public FilmActorId() {
	}
	
	

}
