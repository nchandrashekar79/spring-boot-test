package com.cs.demo.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FilmCateId implements Serializable {
	
	@Column(name = "film_id", nullable = false)
    private short filmId;
	
	@Column(name = "category_id", nullable = false)
    private short categoryId;

    // default constructor

   

	public short getFilmId() {
		return filmId;
	}

	public void setFilmId(short filmId) {
		this.filmId = filmId;
	}

	public short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(short categoryId) {
		this.categoryId = categoryId;
	}

	public FilmCateId(short filmId, short categoryId) {
		super();
		this.filmId = filmId;
		this.categoryId = categoryId;
	}

	public FilmCateId() {
	}

	
    // getters, equals() and hashCode() methods
    
    
}