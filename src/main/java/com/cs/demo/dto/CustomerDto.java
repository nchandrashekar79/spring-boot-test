package com.cs.demo.dto;

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
	Integer storeId;
	
	@Column(name = "first_name", nullable = false)
	String firstName;
	
	@Column(name = "last_name", nullable = false)
	String lastName;
	
	@Column(name = "email", nullable = false)
	String email;
	
	@Column(name = "address_id", nullable = false)
	Integer addressId;
	
	@Column(name = "activebool", nullable = false)
	boolean activebool;
	
	@Column(name = "create_date", nullable = false)
	String createDate;

	@Column(name = "last_update", nullable = false)
	String lastUpdated;
	
	@Column(name = "active", nullable = false)
	String active;
}
