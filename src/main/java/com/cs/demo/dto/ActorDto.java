package com.cs.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "actor")
@Entity
public class ActorDto {

	@Id
	@Column(name = "actor_id", nullable = false)
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="actor_actor_id_seq", allocationSize=1)
	Integer actorId;
	
	@Column(name = "first_name", nullable = false)
	String firstName;
	
	@Column(name = "last_name", nullable = false)
	String lastName;
	
	@Column(name = "last_update", nullable = false)
	String lastUpdated;

	public Integer getActor_id() {
		return actorId;
	}

	public void setActor_id(Integer actor_id) {
		this.actorId = actor_id;
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

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public ActorDto(Integer actorId, String firstName, String lastName, String lastUpdated) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdated = lastUpdated;
	}
	
	

}
