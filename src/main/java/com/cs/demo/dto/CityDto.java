package com.cs.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "city")
@Entity
public class CityDto {
	@Id
	@Column(name = "city_id", nullable = false)
	@GeneratedValue(generator = "city_seq")
	@SequenceGenerator(name = "city_seq", sequenceName = "city_city_id_seq", allocationSize = 1)
	private Integer cityId;
	
	@Column(name = "country")
	private String country;

	@Column(name = "last_update", nullable = false)
	private String lastUpdated;

}
