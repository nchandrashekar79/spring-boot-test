package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class ActorTest {
	
	@Test
	public void test() {
		Actor ac = new Actor(1, "firstname", "lastname", "dd");
		Assert.assertNotNull(ac);
	}

}
