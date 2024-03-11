package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.CityDto;

import junit.framework.Assert;

public class CityDtoTest {
	@Test
	public void test() {
		CityDto ac = new CityDto();
		ac.setCityId(46);
		ac.setCity(null);
		ac.setCountry(null);
		ac.setLastUpdated(null);
		
		ac.getCity();
		ac.getCityId();
		ac.getCountry();
		ac.getLastUpdated();
		Assert.assertNotNull(ac);
	}
}
 