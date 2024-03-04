package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "film_category")
@Entity
public class FilmCategoryDto {

	@EmbeddedId
    private FilmCateId bookId;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	public FilmCateId getBookId() {
		return bookId;
	}

	public void setBookId(FilmCateId bookId) {
		this.bookId = bookId;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public FilmCategoryDto(FilmCateId bookId, Timestamp lastUpdated) {
		super();
		this.bookId = bookId;
		this.lastUpdated = lastUpdated;
	}

	public FilmCategoryDto() {
	}
	
	
	
	
	
}
