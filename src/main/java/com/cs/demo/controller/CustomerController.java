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

import com.cs.demo.dto.CustomerDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.CustomerRepo;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

	private CustomerRepo customerRepo;

	@Autowired
	public CustomerController(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@GetMapping
	public List<CustomerDto> customerFindAll() {
		return customerRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		CustomerDto customer = findById(id);

		System.out.println(customer.getCustomerId());

		return ResponseEntity.ok().body(customer);

	}

	private CustomerDto findById(Integer id) throws ResourceNotFoundException {
		return customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
	}

	@PostMapping
	public CustomerDto createCustomer(@RequestBody CustomerDto customer) {
		return customerRepo.save(customer);
	}

	@PutMapping("{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "id") Integer id,
			@RequestBody CustomerDto customerReq) throws ResourceNotFoundException {

		CustomerDto customer = findById(id);

		customer = mappingCustomerData(customerReq, customer);

		CustomerDto updatedCustomer = customerRepo.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	private CustomerDto mappingCustomerData(CustomerDto customerReq, CustomerDto customer) {
		customer.setCustomerId(customer.getCustomerId());
		customer.setActive(customerReq.getActive());
		return customer;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		CustomerDto customer = findById(id);

		customerRepo.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Address deleted", Boolean.TRUE);
		return response;
	}

}
