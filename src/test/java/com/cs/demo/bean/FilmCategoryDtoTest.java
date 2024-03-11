package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.FilmCateId;
import com.cs.demo.dto.FilmCategoryDto;

import junit.framework.Assert;

public class FilmCategoryDtoTest {
	@Test
	public void test() {
		short idSh =1;
		FilmCateId id = new FilmCateId(idSh,idSh);
		FilmCategoryDto fc = new FilmCategoryDto();
		FilmCategoryDto ac = new FilmCategoryDto(id,null);
		id.setCategoryId((short)0);
		id.setFilmId(idSh);
		
		
		ac.setBookId(new FilmCateId());
		ac.setLastUpdated(null);
		
		
		id.getCategoryId();
		id.getFilmId();
		ac.getBookId();
		ac.getLastUpdated();
		Assert.assertNotNull(ac);
	}
}
