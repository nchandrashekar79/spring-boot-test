package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.CustomerDto;

import junit.framework.Assert;

public class CustomerDtoTest {
	@Test
	public void test() {
		CustomerDto ac = new CustomerDto();
		ac.setActivebool(false);
		ac.setActive(null);
		ac.setAddressId(null);
		ac.setCreateDate(null);
		ac.setCustomerId(null);
		ac.setEmail(null);
		ac.setFirstName(null);
		ac.setLastName(null);
		ac.setLastUpdated(null);
		ac.setStoreId(null);
		ac.isActivebool();
		
		ac.getActive();
		ac.getAddressId();
		ac.getCreateDate();
		ac.getCustomerId();
		ac.getEmail();
		ac.getFirstName();
		ac.getLastName();
		ac.getLastUpdated();
		ac.getStoreId();
		
		
		Assert.assertNotNull(ac);
	}
}
