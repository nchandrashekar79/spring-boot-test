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

import com.cs.demo.dto.CityDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.CityRepo;

@RestController
@RequestMapping("v1/city")
public class CityController {

	private CityRepo cityRepo;

	@Autowired
	public CityController(CityRepo cityRepo) {
		this.cityRepo = cityRepo;
	}

	@GetMapping
	public List<CityDto> cityFindAll() {
		return cityRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCityById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		CityDto cityDto = findById(id);

		System.out.println(cityDto.getCity());

		return ResponseEntity.ok().body(cityDto);

	}

	private CityDto findById(Integer id) throws ResourceNotFoundException {
		return cityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id :: " + id));
	}
	
	@PostMapping
	public CityDto createCountry(@RequestBody CityDto city) {
		return cityRepo.save(city);
	}

	@PutMapping("{id}")
	public ResponseEntity<CityDto> updateCity(@PathVariable(value = "id") Integer id,
			@RequestBody CityDto cityReq) throws ResourceNotFoundException {

		CityDto country = findById(id);
		
		
		country.setCityId(id);
		country.setCity(cityReq.getCity());
		country.setCountry(cityReq.getCountry());
		country.setLastUpdated(new Timestamp(System.currentTimeMillis()));


		CityDto updatedCity = cityRepo.save(country);
		return ResponseEntity.ok(updatedCity);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteCity(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		CityDto country = findById(id);

		cityRepo.delete(country);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
