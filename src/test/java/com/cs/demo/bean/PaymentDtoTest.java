package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.PaymentDto;

import junit.framework.Assert;

public class PaymentDtoTest {
	@Test
	public void test() {
		short id=0;
		PaymentDto ac = new PaymentDto();
		ac.setRentalId(22);
		ac.setAmount(null);
		ac.setCustomerId(id);
		ac.setPaymentDate(null);
		ac.setPaymentId(null);
		ac.setStaffId(id);
		
		ac.getAmount();
		ac.getCustomerId();
		ac.getPaymentDate();
		ac.getPaymentId();
		ac.getRentalId();
		ac.getStaffId();
		
		
		Assert.assertNotNull(ac);
	}
}
