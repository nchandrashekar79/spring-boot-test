package com.cs.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "address")
@Entity
public class AddressDto {

	@Id
	@Column(name = "address_id", nullable = false)
	@GeneratedValue(generator = "address_seq")
	@SequenceGenerator(name = "address_seq", sequenceName = "address_address_id_seq", allocationSize = 1)
	private Integer addressId;

	@Column(name = "address")
	private String address;

	@Column(name = "address2")
	private String address2;

	@Column(name = "district")
	private String district;

	@Column(name = "city_id")
	private String cityId;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "phone")
	private String phone;

	@Column(name = "last_update", nullable = false)
	private String lastUpdated;

}
