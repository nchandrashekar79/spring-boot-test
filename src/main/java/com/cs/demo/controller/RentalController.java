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

import com.cs.demo.dto.RentalDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.RentalRepo;

@RestController
@RequestMapping("v1/Rental")
public class RentalController {

	private RentalRepo RentalRepo;

	@Autowired
	public RentalController(RentalRepo RentalRepo) {
		this.RentalRepo = RentalRepo;
	}

	@GetMapping
	public List<RentalDto> RentalFindAll() {
		return RentalRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getRentalById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		RentalDto Rental = findById(id);

		System.out.println(Rental.getRentalId());

		return ResponseEntity.ok().body(Rental);

	}

	private RentalDto findById(Integer id) throws ResourceNotFoundException {
		return RentalRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rental not found for this id :: " + id));
	}

	@PostMapping
	public RentalDto createRental(@RequestBody RentalDto Rental) {
		return RentalRepo.save(Rental);
	}

	@PutMapping("{id}")
	public ResponseEntity<RentalDto> updateRental(@PathVariable(value = "id") Integer id,
			@RequestBody RentalDto RentalReq) throws ResourceNotFoundException {

		RentalDto Rental = findById(id);

		Rental = mappingRentalData(RentalReq, Rental);

		RentalDto updatedRental = RentalRepo.save(Rental);
		return ResponseEntity.ok(updatedRental);
	}

	private RentalDto mappingRentalData(RentalDto RentalReq, RentalDto Rental) {
		Rental.setCustomerId(RentalReq.getCustomerId());
		return Rental;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteRental(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		RentalDto Rental = findById(id);

		RentalRepo.delete(Rental);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Rental deleted", Boolean.TRUE);
		return response;
	}

}
