package com.cs.demo.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "film")
@Entity
public class FilmDto {

	@Id
	@Column(name = "film_id", nullable = false)
	@GeneratedValue(generator = "film_seq")
	@SequenceGenerator(name = "film_seq", sequenceName = "film_film_id_seq", allocationSize = 1)
	Integer filmId;

	@Column(name = "title")
	String title;

	@Column(name = "description")
	String description;

	/*
	 * @Column(name = "release_year") Date release_year;
	 */

	/*
	 * @Column(name = "language_id") short language_id;
	 */

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
	LanguageDto language;

	@Column(name = "rental_duration")
	Short rental_duration;

	@Column(name = "rental_rate")
	BigDecimal rental_rate;

	@Column(name = "length")
	short length;

	@Column(name = "replacement_cost")
	BigDecimal replacement_cost;

	@Column(name = "rating")
	String rating;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	@Column(name = "special_features")
	String[] special_features;

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getLength() {
		return length;
	}

	public void setLength(short length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Short getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(Short rental_duration) {
		this.rental_duration = rental_duration;
	}

	public BigDecimal getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(BigDecimal rental_rate) {
		this.rental_rate = rental_rate;
	}

	public BigDecimal getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(BigDecimal replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String[] getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String[] special_features) {
		this.special_features = special_features;
	}

	public LanguageDto getLanguage() {
		return language;
	}

	public void setLanguage(LanguageDto language) {
		this.language = language;
	}

	

	/*
	 * @Column(name = "fulltext") String fulltext;
	 */

}
