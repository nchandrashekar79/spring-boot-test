package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.StaffDto;

public interface StaffRepo extends JpaRepository<StaffDto, Integer> {

}
