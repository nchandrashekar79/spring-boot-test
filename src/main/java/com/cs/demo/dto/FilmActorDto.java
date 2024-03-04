package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "film_actor")
@Entity
public class FilmActorDto {

	@EmbeddedId
	FilmActorId filmActorId;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	public FilmActorId getFilmActorId() {
		return filmActorId;
	}

	public void setFilmActorId(FilmActorId filmActorId) {
		this.filmActorId = filmActorId;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
