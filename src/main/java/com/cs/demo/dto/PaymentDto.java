package com.cs.demo.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "payment")
@Entity
public class PaymentDto {

	@Id
	@Column(name = "payment_id", nullable = false)
	@GeneratedValue(generator = "payment_seq")
	@SequenceGenerator(name = "payment_seq", sequenceName = "payment_payment_id_seq", allocationSize = 1)
	Integer paymentId;
	
	@Column(name = "customer_id", nullable = false)
	short customerId;
	
	@Column(name = "staff_id")
	short staffId;
	
	@Column(name = "rental_id")
	Integer rentalId;
	
	@Column(name = "amount")
	BigDecimal amount;
	
	@Column(name = "payment_date", nullable = false)
	Timestamp paymentDate;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public short getCustomerId() {
		return customerId;
	}

	public void setCustomerId(short customerId) {
		this.customerId = customerId;
	}

	public short getStaffId() {
		return staffId;
	}

	public void setStaffId(short staffId) {
		this.staffId = staffId;
	}

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	

}
