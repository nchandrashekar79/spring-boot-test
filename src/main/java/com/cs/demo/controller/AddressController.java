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

import com.cs.demo.dto.AddressDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.AddressRepo;

@RestController
@RequestMapping("v1/address")
public class AddressController {

	private AddressRepo addressRepo;

	@Autowired
	public AddressController(AddressRepo addressRepo) {
		this.addressRepo = addressRepo;
	}

	@GetMapping
	public List<AddressDto> addressFindAll() {
		return addressRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAddressById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		AddressDto address = findById(id);

		System.out.println(address.getAddressId());

		return ResponseEntity.ok().body(address);

	}

	private AddressDto findById(Integer id) throws ResourceNotFoundException {
		return addressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + id));
	}
	
	@PostMapping
	public AddressDto createAddress(@RequestBody AddressDto address) {
		return addressRepo.save(address);
	}

	@PutMapping("{id}")
	public ResponseEntity<AddressDto> updateAddress(@PathVariable(value = "id") Integer id,
			@RequestBody AddressDto addressReq) throws ResourceNotFoundException {

		AddressDto address = findById(id);
		
		
		mapAddressData(id, addressReq, address);


		AddressDto updatedAddress = addressRepo.save(address);
		return ResponseEntity.ok(updatedAddress);
	}

	private void mapAddressData(Integer id, AddressDto addressReq, AddressDto address) {
		address.setAddressId(id);
		address.setAddress(addressReq.getAddress());
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		AddressDto address = findById(id);

		addressRepo.delete(address);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Address deleted", Boolean.TRUE);
		return response;
	}

}
