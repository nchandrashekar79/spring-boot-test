package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.CategoryDto;

import junit.framework.Assert;

public class CategoryDtoTest {
	@Test
	public void test() {
		CategoryDto ac = new CategoryDto();
		ac.setCategoryId(33);
		ac.setLastUpdated(null);
		ac.setName(null);
		
		ac.getCategoryId();
		ac.getLastUpdated();
		ac.getName();
		
		Assert.assertNotNull(ac);
	}
}
