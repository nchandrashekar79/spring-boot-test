package com.cs.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.cs.demo.bean.Actor;
import com.cs.demo.dto.ActorDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.service.ActorService;

@ExtendWith(MockitoExtension.class)
public class ActorControllerTest {

	@InjectMocks
	ActorController actorController;

	@Mock
	ActorService actorService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	public void getActorsTest() {

		List<ActorDto> list = new ArrayList<>();
		ActorDto ac = new ActorDto(1, "firstname", "lastname", "dd");
		list.add(ac);

		when(actorService.findAll()).thenReturn(list);
		List<ActorDto> accList = actorController.getActors();
		assertEquals(1, accList.size());

	}

	@Test
	public void test() {

		String str = actorController.test();
		assertNotNull(str);

	}
	
	@Test
	public void getActorsByIdTest() throws ResourceNotFoundException {

		ActorDto actorDto = new ActorDto(1, "firstname", "lastname", "dd");
		
		Actor ac = new Actor(actorDto.getActor_id(), actorDto.getFirstName(), actorDto.getLastName(),
				actorDto.getLastUpdated());
		
		Optional<ActorDto> opDto = Optional.of(actorDto);
		when(actorService.findById(1)).thenReturn(opDto);
		
		
		ResponseEntity<Actor> accList = actorController.getActorsById(1);
		
		assertNotNull(accList.getBody().firstName());

	}
	
	public void getActorsByIdTest2() throws ResourceNotFoundException {

		ActorDto actorDto = new ActorDto(1, "firstname", "lastname", "dd");
		
		Actor ac = new Actor(actorDto.getActor_id(), actorDto.getFirstName(), actorDto.getLastName(),
				actorDto.getLastUpdated());
		
		Optional<ActorDto> opDto = Optional.of(actorDto);
		when(actorService.findById(10)).thenThrow(new ResourceNotFoundException("Actor not found for this id :: " + 10));
		
		ResponseEntity<Actor> accList = null;
		 
		try {
			 accList = actorController.getActorsById(1);
		}
		catch(Exception e) {
			
		}
		
		
		assertNotNull(accList.getBody().firstName());

	}
}
