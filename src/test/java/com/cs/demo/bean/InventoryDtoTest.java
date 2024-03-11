package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.InventoryDto;

import junit.framework.Assert;

public class InventoryDtoTest {
	@Test
	public void test() {
		short id=9;
		InventoryDto ac = new InventoryDto();
		ac.setInventoryId(34);
		ac.setLastUpdated(null);
		ac.setFilm_id(id);
		ac.setStore_id(id);
		
		ac.getInventoryId();
		ac.getLastUpdated();
		ac.getFilm_id();
		ac.getStore_id();
		
		Assert.assertNotNull(ac);
	}
}
