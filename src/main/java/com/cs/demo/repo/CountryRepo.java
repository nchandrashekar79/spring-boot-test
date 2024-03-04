package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.CountryDto;

public interface CountryRepo extends JpaRepository<CountryDto, Integer> {

}
