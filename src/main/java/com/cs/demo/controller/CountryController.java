package com.cs.demo.controller;

import java.sql.Timestamp;
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

import com.cs.demo.dto.CountryDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.CountryRepo;

@RestController
@RequestMapping("v1/country")
public class CountryController {

	private CountryRepo countryRepo;

	@Autowired
	public CountryController(CountryRepo countryRepo) {
		this.countryRepo = countryRepo;
	}

	@GetMapping
	public List<CountryDto> countryFindAll() {
		return countryRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCountryById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		CountryDto countryDto = findById(id);

		System.out.println(countryDto.getCountryId());

		return ResponseEntity.ok().body(countryDto);

	}

	private CountryDto findById(Integer id) throws ResourceNotFoundException {
		CountryDto countryDto = countryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Country not found for this id :: " + id));
		return countryDto;
	}
	
	@PostMapping
	public CountryDto createCountry(@RequestBody CountryDto county) {
		return countryRepo.save(county);
	}

	@PutMapping("{id}")
	public ResponseEntity<CountryDto> updateCountry(@PathVariable(value = "id") Integer id,
			@RequestBody CountryDto countryReq) throws ResourceNotFoundException {

		CountryDto country = findById(id);
		
		country.setCountryId(id);
		country.setCountry(countryReq.getCountry());
		country.setLastUpdated(new Timestamp(System.currentTimeMillis()));


		CountryDto updatedCountry = countryRepo.save(country);
		return ResponseEntity.ok(updatedCountry);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteActor(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		CountryDto country = findById(id);

		countryRepo.delete(country);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
