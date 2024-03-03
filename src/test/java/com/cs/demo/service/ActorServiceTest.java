package com.cs.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.cs.demo.dto.ActorDto;
import com.cs.demo.repo.ActorRepo;

@ExtendWith(MockitoExtension.class)
public class ActorServiceTest {

	@InjectMocks
	ActorService actorService;

	@Mock
	ActorRepo dao;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

	}

	@Test
	public void findAllTest() {
		List<ActorDto> list = new ArrayList<>();
		ActorDto ac = new ActorDto(1, "firstname", "lastname", "dd");
		ActorDto ac2 = new ActorDto(2, "firstname", "lastname", "dd");

		list.add(ac);
		list.add(ac2);
		when(dao.findAll()).thenReturn(list);

		List<ActorDto> actorList = actorService.findAll();
		assertEquals(2, actorList.size());
		verify(dao, times(1)).findAll();

	}

	@Test
	public void findByIdTest() {
		ActorDto ac = new ActorDto(1, "firstname", "lastname", "dd");

		Optional<ActorDto> optionalAc = Optional.of(ac);

		when(dao.findById(1)).thenReturn(optionalAc);

		Optional<ActorDto> actorList = actorService.findById(1);
		assertNotNull(actorList.get());

	}

	@Test
	public void saveTest() {
		ActorDto ac = new ActorDto(1, "firstname", "lastname", "dd");

		when(dao.save(ac)).thenReturn(ac);
		ActorDto act = actorService.save(ac);
		assertNotNull(act);

	}

}
