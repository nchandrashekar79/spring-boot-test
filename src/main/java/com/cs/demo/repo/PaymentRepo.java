package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.dto.PaymentDto;

public interface PaymentRepo extends JpaRepository<PaymentDto, Integer> {

}
