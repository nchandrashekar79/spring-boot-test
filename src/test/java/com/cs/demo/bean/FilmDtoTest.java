package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.FilmDto;

import junit.framework.Assert;

public class FilmDtoTest {
	@Test
	public void test() {
		short id=9;
		FilmDto ac = new FilmDto();
		ac.setFilmId(555);
		ac.setDescription(null);
		ac.setLanguage(null);
		ac.setLastUpdated(null);
		ac.setLength(id);
		ac.setRating(null);
		ac.setRental_duration(null);
		ac.setRental_rate(null);
		ac.setReplacement_cost(null);
		ac.setSpecial_features(null);
		ac.setTitle(null);
		
		ac.getDescription();
		ac.getFilmId();
		ac.getLanguage();
		ac.getLastUpdated();
		ac.getLength();
		ac.getRating();
		ac.getRental_duration();
		ac.getRental_rate();
		ac.getReplacement_cost();
		ac.getSpecial_features();
		ac.getTitle();
		Assert.assertNotNull(ac);
	}
}
