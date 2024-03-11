package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.LanguageDto;

import junit.framework.Assert;

public class LanguageDtoTest {
	@Test
	public void test() {
		LanguageDto ac = new LanguageDto();
		ac.setLanguageId(1);
		ac.setLastUpdated(null);
		ac.setName(null);
		
		ac.getLanguageId();
		ac.getLastUpdated();
		ac.getName();
		Assert.assertNotNull(ac);
	}
}
