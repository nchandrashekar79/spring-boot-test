package com.cs.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.bean.Actor;
import com.cs.demo.dto.ActorDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.service.ActorService;

@RestController
@RequestMapping("/v1/actor")
public class ActorController {
	ActorService actorService;

	@Autowired
	public ActorController(ActorService repo) {
		this.actorService = repo;
	}

	@GetMapping
	public List<ActorDto> getActors() {
		return actorService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Actor> getActorsById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		ActorDto actorDto = findById(id);

		System.out.println(actorDto.getFirstName());
		Actor ac = new Actor(actorDto.getActorId(), actorDto.getFirstName(), actorDto.getLastName(),
				actorDto.getLastUpdated());
		return ResponseEntity.ok().body(ac);

	}

	@PostMapping
	public ActorDto createActor(@RequestBody ActorDto actor) {
		return actorService.save(actor);
	}

	@PutMapping("{id}")
	public ResponseEntity<ActorDto> updateActor(@PathVariable(value = "id") Integer id,
			@RequestBody ActorDto actorReq) throws ResourceNotFoundException {

		ActorDto actor = mapActorData(id, actorReq);

		ActorDto updatedActor = actorService.save(actor);
		return ResponseEntity.ok(updatedActor);
	}

	private ActorDto mapActorData(Integer id, ActorDto actorReq) throws ResourceNotFoundException {
		ActorDto actor = findById(id);

		actor.setActorId(actor.getActorId());
		actor.setFirstName(actorReq.getFirstName());
		actor.setLastName(actorReq.getLastName());
		actor.setLastUpdated(actorReq.getLastUpdated());
		return actor;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteActor(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		ActorDto Actor = findById(id);

		actorService.delete(Actor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	private ActorDto findById(Integer id) throws ResourceNotFoundException {
		return actorService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor not found for this id :: " + id));
	}

}
