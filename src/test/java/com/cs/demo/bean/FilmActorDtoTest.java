package com.cs.demo.bean;

import org.junit.jupiter.api.Test;

import com.cs.demo.dto.FilmActorDto;
import com.cs.demo.dto.FilmActorId;

import junit.framework.Assert;

public class FilmActorDtoTest {
	@Test
	public void test() {
		FilmActorDto filmActor = new FilmActorDto();
		FilmActorId id = new FilmActorId();
		short actorId=1;
		short filmId=2;
		id.setActorId(actorId);
		id.setFilmId(filmId);
		
		filmActor.setFilmActorId(id);
		filmActor.setLastUpdated(null);
		
		filmActor.getFilmActorId();
		filmActor.getLastUpdated();
		
		id.getActorId();
		id.getFilmId();
		
		
		
		Assert.assertNotNull(filmActor);
	}
}
