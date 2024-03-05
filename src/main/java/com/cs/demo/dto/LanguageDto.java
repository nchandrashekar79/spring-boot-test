package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "language")
@Entity
public class LanguageDto {

	@Id
	@Column(name = "language_id", nullable = false)
	@GeneratedValue(generator = "language_seq")
	@SequenceGenerator(name = "language_seq", sequenceName = "language_language_id_seq", allocationSize = 1)
	Integer languageId;

	@Column(name = "name", nullable = false)
	char[] name;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public char[] getName() {
		return name;
	}

	public void setName(char[] name) {
		this.name = name;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

}
