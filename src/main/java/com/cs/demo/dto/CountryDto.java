package com.cs.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "country")
@Entity
public class CountryDto {
	
	@Id
	@Column(name = "country_id", nullable = false)
	@GeneratedValue(generator = "country_seq")
	@SequenceGenerator(name = "country_seq", sequenceName = "country_country_id_seq", allocationSize = 1)
	Integer countryId;
	
	@Column(name = "country")
	String country;

	@Column(name = "last_update", nullable = false)
	String lastUpdated;

}
