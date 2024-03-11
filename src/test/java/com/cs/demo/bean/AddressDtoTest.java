package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.AddressDto;

import junit.framework.Assert;

public class AddressDtoTest {
	@Test
	public void test() {
		AddressDto ac = new AddressDto();
		ac.setAddressId(32);
		ac.setAddress(null);
		ac.setAddress2(null);
		ac.setCityId(null);
		ac.setDistrict(null);
		ac.setLastUpdated(null);
		ac.setPhone(null);
		ac.setPostalCode(null);
		
		ac.getAddress();
		ac.getAddress2();
		ac.getAddressId();
		ac.getCityId();
		ac.getDistrict();
		ac.getLastUpdated();
		ac.getPhone();
		ac.getPostalCode();
		
		Assert.assertNotNull(ac);
	}
}
