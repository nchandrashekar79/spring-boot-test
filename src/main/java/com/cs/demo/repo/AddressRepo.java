package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.AddressDto;

public interface AddressRepo extends JpaRepository<AddressDto, Integer> {

}
