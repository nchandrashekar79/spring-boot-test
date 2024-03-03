package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.ActorDto;

public interface ActorRepo extends JpaRepository<ActorDto, Integer> {

}
