package com.cs.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.repo.ActorRepo;

@Service
public class ActorService {

	private ActorRepo repo;

	public ActorService(ActorRepo repo) {
		this.repo = repo;
	}

	public List<ActorDto> findAll() {
		return repo.findAll();
	}

	public Optional<ActorDto> findById(Integer id) {
		return repo.findById(id);
	}

	public ActorDto save(ActorDto actor) {
		return repo.save(actor);
	}

	public void delete(ActorDto actor) {
		repo.delete(actor);
	}

}
