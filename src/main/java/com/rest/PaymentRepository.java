package com.rest;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, BigDecimal> {
}
