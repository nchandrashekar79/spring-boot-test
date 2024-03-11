package com.cs.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cs.demo.controller.ActorController;
import com.cs.demo.dto.ActorDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ActorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private ActorController actoreController;

	@Mock
	private ActorService actorService;

	@Autowired
	private ObjectMapper objectMapper;

	//@Test
	public void test() throws Exception {
		ActorDto input = new ActorDto(1, "test", null, null);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		 when(actorService.save(any(ActorDto.class))).thenReturn(input);
		 
		ActorDto response =  actoreController.createActor(input);
		
		assertThat(response.getActorId()).isEqualTo(1);
		 
		 
	}
}