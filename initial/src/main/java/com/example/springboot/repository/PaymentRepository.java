package com.example.springboot.repository;

import com.example.springboot.model.Payment;

import java.util.Optional;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findByTransactionId(String transactionId);
}