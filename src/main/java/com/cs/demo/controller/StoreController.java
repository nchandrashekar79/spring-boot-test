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

import com.cs.demo.dto.StoreDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.StoreRepo;

@RestController
@RequestMapping("v1/store")
public class StoreController {

	private StoreRepo storeRepo;

	@Autowired
	public StoreController(StoreRepo storeRepo) {
		this.storeRepo = storeRepo;
	}

	@GetMapping
	public List<StoreDto> StoreFindAll() {
		return storeRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStoreById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		StoreDto Store = findById(id);

		System.out.println(Store.getStoreId());

		return ResponseEntity.ok().body(Store);

	}

	private StoreDto findById(Integer id) throws ResourceNotFoundException {
		return storeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Store not found for this id :: " + id));
	}

	@PostMapping
	public StoreDto createStore(@RequestBody StoreDto Store) {
		return storeRepo.save(Store);
	}

	@PutMapping("{id}")
	public ResponseEntity<StoreDto> updateStore(@PathVariable(value = "id") Integer id,
			@RequestBody StoreDto StoreReq) throws ResourceNotFoundException {

		StoreDto Store = findById(id);

		Store = mappingStoreData(StoreReq, Store);

		StoreDto updatedStore = storeRepo.save(Store);
		return ResponseEntity.ok(updatedStore);
	}

	private StoreDto mappingStoreData(StoreDto storeReq, StoreDto store) {
		store.setAddressId(storeReq.getAddressId());
		return store;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteStore(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		StoreDto store = findById(id);

		storeRepo.delete(store);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Store deleted", Boolean.TRUE);
		return response;
	}

}
