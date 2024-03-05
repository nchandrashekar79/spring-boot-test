package com.cs.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.dto.InventoryDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.InventoryRepo;

@RestController
@RequestMapping("v1/inventory")
public class InventoryController {

	private InventoryRepo InventoryRepo;

	@Autowired
	public InventoryController(InventoryRepo InventoryRepo) {
		this.InventoryRepo = InventoryRepo;
	}

	@GetMapping
	public List<InventoryDto> InventoryFindAll() {
		return InventoryRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getInventoryById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		InventoryDto Inventory = findById(id);

		System.out.println(Inventory.getInventoryId());

		return ResponseEntity.ok().body(Inventory);

	}

	private InventoryDto findById(Integer id) throws ResourceNotFoundException {
		return InventoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + id));
	}

	@PostMapping
	public InventoryDto createInventory(@RequestBody InventoryDto Inventory) {
		return InventoryRepo.save(Inventory);
	}

	@PutMapping("{id}")
	public ResponseEntity<InventoryDto> updateInventory(@PathVariable(value = "id") Integer id,
			@RequestBody InventoryDto InventoryReq) throws ResourceNotFoundException {

		InventoryDto Inventory = findById(id);

		Inventory = mappingInventoryData(InventoryReq, Inventory);

		InventoryDto updatedInventory = InventoryRepo.save(Inventory);
		return ResponseEntity.ok(updatedInventory);
	}

	private InventoryDto mappingInventoryData(InventoryDto InventoryReq, InventoryDto Inventory) {
		Inventory.setFilm_id(InventoryReq.getFilm_id()); 
		return Inventory;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteInventory(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		InventoryDto Inventory = findById(id);

		InventoryRepo.delete(Inventory);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Inventory deleted", Boolean.TRUE);
		return response;
	}

}
