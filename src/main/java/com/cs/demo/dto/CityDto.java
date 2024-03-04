package com.cs.demo.dto;

import java.sql.Timestamp;

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

	@Column(name = "city")
	private String city;

	@Column(name = "country_id")
	private Short country;

	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdated;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Short getCountry() {
		return country;
	}

	public void setCountry(Short country) {
		this.country = country;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

}
