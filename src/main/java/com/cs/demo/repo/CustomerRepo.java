package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.CustomerDto;

public interface CustomerRepo extends JpaRepository<CustomerDto, Integer> {

}
