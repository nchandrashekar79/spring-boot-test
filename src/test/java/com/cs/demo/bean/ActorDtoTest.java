package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;

import junit.framework.Assert;

public class ActorDtoTest {
	
	@Test
	public void test() {
		ActorDto ac = new ActorDto(1,"test","test",null);
		ac.setActorId(2);
		ac.setFirstName("test");
		ac.setLastName("test");
		ac.setLastUpdated(null);
		Assert.assertNotNull(ac);
	}
}
