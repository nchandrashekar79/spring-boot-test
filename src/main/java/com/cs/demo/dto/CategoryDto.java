package com.cs.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "category")
@Entity
public class CategoryDto {

	@Id

	@Column(name = "category_id", nullable = false)

	@GeneratedValue(generator = "category_seq")

	@SequenceGenerator(name = "category_seq", sequenceName = "category_category_id_seq", allocationSize = 1)
	Integer categoryId;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "last_update", nullable = false)
	String lastUpdated;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
