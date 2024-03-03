package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.CategoryDto;

public interface CategoryRepo extends JpaRepository<CategoryDto, Integer> {

}
