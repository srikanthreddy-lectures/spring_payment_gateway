package com.example.springboot.repository;

import com.example.springboot.model.Payment;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPaymentRepository implements PaymentRepository {

    private final Map<String, Payment> paymentStore = new ConcurrentHashMap<>();

    @Override
    public Payment save(Payment payment) {
        paymentStore.put(payment.getTransactionId(), payment);
        return payment;
    }

    @Override
    public Optional<Payment> findByTransactionId(String transactionId) {
        return Optional.ofNullable(paymentStore.get(transactionId));
    }
}