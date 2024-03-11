package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.StaffDto;

import junit.framework.Assert;

public class StaffDtoTest {

	@Test
	public void test() {
		short id=1;
		String data="test";
		StaffDto staff = new StaffDto();
		staff.setActive(false);
		staff.setAddressId(id);
		staff.setEmail(data);
		staff.setFirstName(data);
		staff.setLastName(data);
		staff.setPassword(data);
		staff.setPicture(null);
		staff.setStaffId(4);
		staff.setStaffId(7);
		staff.setStoreId(id);
		staff.setUsername(data);
		staff.setLastUpdated(null);
		
		staff.getActive();
		staff.getAddressId();
		staff.getEmail();
		staff.getFirstName();
		staff.getLastName();
		staff.getLastUpdated();
		staff.getPassword();
		staff.getPicture();
		staff.getStaffId();
		staff.getStoreId();
		staff.getUsername();
		
		Assert.assertNotNull(staff);
	}
}
