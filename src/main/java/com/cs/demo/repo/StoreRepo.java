package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.StoreDto;

public interface StoreRepo extends JpaRepository<StoreDto, Integer> {

}
