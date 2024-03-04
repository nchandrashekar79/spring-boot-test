package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.LanguageDto;

public interface LanguageRepo extends JpaRepository<LanguageDto, Integer> {

}
