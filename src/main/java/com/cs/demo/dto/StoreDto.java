package com.cs.demo.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "store")
@Entity
public class StoreDto {

	@Id
	@Column(name = "store_id", nullable = false)
	@GeneratedValue(generator = "store_seq")
	@SequenceGenerator(name = "store_seq", sequenceName = "store_store_id_seq", allocationSize = 1)
	Integer storeId;

	@Column(name = "manager_staff_id")
	Short managerStaffId;

	@Column(name = "address_id")
	Short addressId;

	@Column(name = "last_update", nullable = false)
	Timestamp lastUpdated;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Short getManagerStaffId() {
		return managerStaffId;
	}

	public void setManagerStaffId(Short managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	public Short getAddressId() {
		return addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
