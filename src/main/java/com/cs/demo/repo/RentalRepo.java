package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.RentalDto;

public interface RentalRepo extends JpaRepository<RentalDto, Integer> {

}
