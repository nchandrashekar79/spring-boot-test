package com.cs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.bean.Category;
import com.cs.demo.dto.CategoryDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.CategoryRepo;

@RestController
@RequestMapping("v1/category")
public class CategoryController {
	
	private CategoryRepo categoryRepo;

	@Autowired
	public CategoryController(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@GetMapping
	public List<CategoryDto> getCategories() {
		return categoryRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		CategoryDto categoryDto = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));

		System.out.println(categoryDto.getName());
		Category cat = new Category(categoryDto.getCategoryId(), categoryDto.getName(), categoryDto.getLastUpdated());
		return ResponseEntity.ok().body(cat);

	}

	/*
	 * @PostMapping public ActorDto createEmployee(@RequestBody ActorDto actor) {
	 * return actorService.save(actor); }
	 * 
	 * @PutMapping("{id}") public ResponseEntity<ActorDto>
	 * updateEmployee(@PathVariable(value = "id") Integer id,
	 * 
	 * @RequestBody ActorDto actorReq) throws ResourceNotFoundException {
	 * 
	 * ActorDto actor = actorService.findById(id) .orElseThrow(() -> new
	 * ResourceNotFoundException("Actor not found for this id :: " + id));
	 * 
	 * actor.setActor_id(actor.getActor_id());
	 * actor.setFirstName(actorReq.getFirstName());
	 * actor.setLastName(actorReq.getLastName());
	 * actor.setLastUpdated(actorReq.getLastUpdated());
	 * 
	 * ActorDto updatedActor = actorService.save(actor); return
	 * ResponseEntity.ok(updatedActor); }
	 * 
	 * @DeleteMapping("{id}") public Map<String, Boolean>
	 * deleteActor(@PathVariable(value = "id") Integer id) throws
	 * ResourceNotFoundException { ActorDto employee = actorService.findById(id)
	 * .orElseThrow(() -> new
	 * ResourceNotFoundException("Actor not found for this id :: " + id));
	 * 
	 * actorService.delete(employee); Map<String, Boolean> response = new
	 * HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
	 */

}
