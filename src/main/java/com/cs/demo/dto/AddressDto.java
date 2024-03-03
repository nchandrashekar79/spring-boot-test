package com.cs.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class AddressDto {

	@Id
	@Column(name = "actor_id", nullable = false)
	@GeneratedValue(generator = "my_seq")
	@SequenceGenerator(name = "my_seq", sequenceName = "actor_actor_id_seq", allocationSize = 1)
	Integer actorId;

	@Column(name = "last_update", nullable = false)
	String lastUpdated;

}
