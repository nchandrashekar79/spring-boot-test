package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.FilmActorDto;
import com.cs.demo.dto.FilmActorId;

public interface FilmActorRepo extends JpaRepository<FilmActorDto, FilmActorId> {

}
