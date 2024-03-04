package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "staff")
@Entity
public class StaffDto {

	@Id
	@Column(name = "staff_id", nullable = false)
	@GeneratedValue(generator = "staff_seq")
	@SequenceGenerator(name = "staff_seq", sequenceName = "staff_staff_id_seq", allocationSize = 1)
	Integer staffId;
	
	@Column(name = "first_name", nullable = false)
	String firstName;

	@Column(name = "last_name", nullable = false)
	String lastName;
	
	@Column(name = "address_id", nullable = false)
	Short addressId;
	
	@Column(name = "email", nullable = false)
	String email;
	
	@Column(name = "store_id", nullable = false)
	Short storeId;
	
	@Column(name = "active", nullable = false)
	Boolean active;
	
	@Column(name = "username", nullable = false)
	String username;
	
	@Column(name = "password", nullable = false)
	String password;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;
	
	@Column(name = "picture", nullable = false)
	byte[] picture;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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

	public Short getAddressId() {
		return addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getStoreId() {
		return storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
}
