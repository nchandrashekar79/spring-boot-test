package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.InventoryDto;

public interface InventoryRepo extends JpaRepository<InventoryDto, Integer> {

}
