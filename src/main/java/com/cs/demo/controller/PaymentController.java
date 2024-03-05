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

import com.cs.demo.dto.PaymentDto;
import com.cs.demo.exception.ResourceNotFoundException;
import com.cs.demo.repo.PaymentRepo;

@RestController
@RequestMapping("v1/payment")
public class PaymentController {

	private PaymentRepo paymentRepo;

	@Autowired
	public PaymentController(PaymentRepo paymentRepo) {
		this.paymentRepo = paymentRepo;
	}

	@GetMapping
	public List<PaymentDto> PaymentFindAll() {
		return paymentRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

		PaymentDto Payment = findById(id);

		System.out.println(Payment.getPaymentId());

		return ResponseEntity.ok().body(Payment);

	}

	private PaymentDto findById(Integer id) throws ResourceNotFoundException {
		return paymentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + id));
	}

	@PostMapping
	public PaymentDto createPayment(@RequestBody PaymentDto Payment) {
		return paymentRepo.save(Payment);
	}

	@PutMapping("{id}")
	public ResponseEntity<PaymentDto> updatePayment(@PathVariable(value = "id") Integer id,
			@RequestBody PaymentDto PaymentReq) throws ResourceNotFoundException {

		PaymentDto Payment = findById(id);

		Payment = mappingPaymentData(PaymentReq, Payment);

		PaymentDto updatedPayment = paymentRepo.save(Payment);
		return ResponseEntity.ok(updatedPayment);
	}

	private PaymentDto mappingPaymentData(PaymentDto paymentReq, PaymentDto payment) {
		payment.setCustomerId(paymentReq.getCustomerId());
		return payment;
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deletePayment(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		PaymentDto Payment = findById(id);

		paymentRepo.delete(Payment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Payment deleted", Boolean.TRUE);
		return response;
	}

}
