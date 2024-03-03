package com.cs.demo.dto;

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
	
	@Column(name = "manager_staff_id", nullable = false)
	String managerStaffId;
	
	@Column(name = "address_id")
	String addressId;

	@Column(name = "last_update", nullable = false)
	String lastUpdated;
}
