package com.example.paymentgateway.repository;

import com.example.paymentgateway.model.Payment;

import java.util.Optional;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findByTransactionId(String transactionId);
}