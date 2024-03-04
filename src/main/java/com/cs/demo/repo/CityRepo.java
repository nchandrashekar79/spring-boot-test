package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.CityDto;

public interface CityRepo extends JpaRepository<CityDto, Integer> {

}
