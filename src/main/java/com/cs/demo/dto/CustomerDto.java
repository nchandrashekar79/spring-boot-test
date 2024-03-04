package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "customer")
@Entity
public class CustomerDto {

	@Id
	@Column(name = "customer_id", nullable = false)
	@GeneratedValue(generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_customer_id_seq", allocationSize = 1)
	Integer customerId;

	@Column(name = "store_id", nullable = false)
	Short storeId;

	@Column(name = "first_name", nullable = false)
	String firstName;

	@Column(name = "last_name", nullable = false)
	String lastName;

	@Column(name = "email", nullable = false)
	String email;

	@Column(name = "address_id", nullable = false)
	Short addressId;

	@Column(name = "activebool", nullable = false)
	boolean activebool;

	/*
	 * @Column(name = "create_date") Timestamp createDate;
	 */

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	@Column(name = "active", nullable = false)
	Integer active;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Short getStoreId() {
		return storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getAddressId() {
		return addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	public boolean isActivebool() {
		return activebool;
	}

	public void setActivebool(boolean activebool) {
		this.activebool = activebool;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
	
}
