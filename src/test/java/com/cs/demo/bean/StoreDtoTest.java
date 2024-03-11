package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.StoreDto;

import junit.framework.Assert;

public class StoreDtoTest {

	@Test
	public void test() {
		short id=1;
		StoreDto store = new StoreDto();
		store.setStoreId(1);
		store.setAddressId(id);
		store.setLastUpdated(null);
		store.setManagerStaffId(id);
		
		store.getAddressId();
		store.getManagerStaffId();
		store.getStoreId();
		store.getLastUpdated();
		Assert.assertNotNull(store);
	}
}
