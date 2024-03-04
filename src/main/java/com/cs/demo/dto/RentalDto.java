package com.cs.demo.dto;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "rental")
@Entity
public class RentalDto {

	@Id
	@Column(name = "rental_id", nullable = false)
	@GeneratedValue(generator = "rental_seq")
	@SequenceGenerator(name = "rental_seq", sequenceName = "rental_rental_id_seq", allocationSize = 1)
	Integer rentalId;
	
	@Column(name = "rental_date")
	Date rentalDate;
	
	@Column(name = "inventory_id")
	Integer inventoryId;
	
	@Column(name = "customer_id")
	Short customerId;
	
	@Column(name = "return_date")
	Date returnDate;
	
	@Column(name = "staff_id")
	Short staffId;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Short getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Short getStaffId() {
		return staffId;
	}

	public void setStaffId(Short staffId) {
		this.staffId = staffId;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
}
