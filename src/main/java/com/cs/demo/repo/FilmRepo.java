package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.FilmDto;

public interface FilmRepo extends JpaRepository<FilmDto, Integer> {

}
