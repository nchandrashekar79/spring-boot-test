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

import com.cs.demo.dto.LanguageDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.LanguageRepo;

@RestController
@RequestMapping("v1/lang")
public class LanguageController {

	private LanguageRepo langRepo;

	@Autowired
	public LanguageController(LanguageRepo langRepo) {
		this.langRepo = langRepo;
	}

	@GetMapping
	public List<LanguageDto> langFindAll() {
		return langRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLangById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		LanguageDto lang = findById(id);

		System.out.println(lang.getName());

		return ResponseEntity.ok().body(lang);

	}

	private LanguageDto findById(Integer id) throws ResourceNotFoundException {
		return langRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Language not found for this id :: " + id));
	}
	
	@PostMapping
	public LanguageDto createLanguage(@RequestBody LanguageDto lang) {
		return langRepo.save(lang);
	}

	@PutMapping("{id}")
	public ResponseEntity<LanguageDto> updateLanguage(@PathVariable(value = "id") Integer id,
			@RequestBody LanguageDto langReq) throws ResourceNotFoundException {

		LanguageDto language = findById(id);
		
		language.setLanguageId(id);
		language.setName(langReq.getName());
		language.setLastUpdated(new Timestamp(System.currentTimeMillis()));


		LanguageDto updatedLang = langRepo.save(language);
		return ResponseEntity.ok(updatedLang);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteCity(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		LanguageDto country = findById(id);

		langRepo.delete(country);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Language deleted", Boolean.TRUE);
		return response;
	}

}
