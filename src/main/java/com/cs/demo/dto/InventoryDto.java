package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "inventory")
@Entity
public class InventoryDto {

	@Id
	@Column(name = "inventory_id", nullable = false)
	@GeneratedValue(generator = "inventory_seq")
	@SequenceGenerator(name = "inventory_seq", sequenceName = "inventory_inventory_id_seq", allocationSize = 1)
	Integer inventoryId;

	@Column(name = "film_id")
	short film_id;

	@Column(name = "store_id")
	short store_id;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;


	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public short getFilm_id() {
		return film_id;
	}

	public void setFilm_id(short film_id) {
		this.film_id = film_id;
	}

	public short getStore_id() {
		return store_id;
	}

	public void setStore_id(short store_id) {
		this.store_id = store_id;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
