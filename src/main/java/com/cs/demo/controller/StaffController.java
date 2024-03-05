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

import com.cs.demo.dto.StaffDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.StaffRepo;

@RestController
@RequestMapping("v1/staff")
public class StaffController {

	private StaffRepo staffRepo;

	@Autowired
	public StaffController(StaffRepo staffRepo) {
		this.staffRepo = staffRepo;
	}

	@GetMapping
	public List<StaffDto> StaffFindAll() {
		return staffRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStaffById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		StaffDto Staff = findById(id);

		System.out.println(Staff.getStaffId());

		return ResponseEntity.ok().body(Staff);

	}

	private StaffDto findById(Integer id) throws ResourceNotFoundException {
		return staffRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Staff not found for this id :: " + id));
	}

	@PostMapping
	public StaffDto createStaff(@RequestBody StaffDto Staff) {
		return staffRepo.save(Staff);
	}

	@PutMapping("{id}")
	public ResponseEntity<StaffDto> updateStaff(@PathVariable(value = "id") Integer id,
			@RequestBody StaffDto StaffReq) throws ResourceNotFoundException {

		StaffDto Staff = findById(id);

		Staff = mappingStaffData(StaffReq, Staff);

		StaffDto updatedStaff = staffRepo.save(Staff);
		return ResponseEntity.ok(updatedStaff);
	}

	private StaffDto mappingStaffData(StaffDto StaffReq, StaffDto Staff) {
		Staff.setAddressId(StaffReq.getAddressId());
		return Staff;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteStaff(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		StaffDto Staff = findById(id);

		staffRepo.delete(Staff);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Staff deleted", Boolean.TRUE);
		return response;
	}

}
