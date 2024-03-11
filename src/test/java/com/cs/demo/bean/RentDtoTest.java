package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.RentalDto;

import junit.framework.Assert;

public class RentDtoTest {

	@Test
	public void test() {
		short id = 8;
		RentalDto ac = new RentalDto();
		ac.setRentalId(12);
		ac.setCustomerId(null);
		ac.setInventoryId(null);
		ac.setLastUpdated(null);
		ac.setRentalDate(null);
		ac.setReturnDate(null);
		ac.setStaffId(id);
		
		ac.getCustomerId();
		ac.getInventoryId();
		ac.getLastUpdated();
		ac.getRentalDate();
		ac.getRentalId();
		ac.getReturnDate();
		ac.getStaffId();
		
		
		Assert.assertNotNull(ac);
	}

}
