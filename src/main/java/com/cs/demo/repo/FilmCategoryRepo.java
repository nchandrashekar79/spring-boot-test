package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.ActorDto;
import com.cs.demo.dto.FilmCateId;
import com.cs.demo.dto.FilmCategoryDto;

public interface FilmCategoryRepo extends JpaRepository<FilmCategoryDto, FilmCateId> {

}
