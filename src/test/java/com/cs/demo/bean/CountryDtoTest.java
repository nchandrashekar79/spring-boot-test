package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.CountryDto;

import junit.framework.Assert;

public class CountryDtoTest {
	@Test
	public void test() {
		CountryDto ac = new CountryDto();
		ac.setCountryId(98);
		ac.setCountry(null);
		ac.setLastUpdated(null);
		
		ac.getCountry();
		ac.getCountryId();
		ac.getLastUpdated();
		
		Assert.assertNotNull(ac);
	}
}
