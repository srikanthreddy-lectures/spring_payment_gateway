package com.example.paymentgateway.service;

import com.example.paymentgateway.model.Payment;
import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.repository.PaymentRepository;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment processPayment(PaymentRequest paymentRequest) {
        // Simulate payment processing logic
        String status = "SUCCESS"; // or "FAILED" based on some logic

        Payment payment = new Payment(paymentRequest, status);
        paymentRepository.save(payment);

        return payment;
    }

    @Override
    public Payment getPaymentStatus(String transactionId) {
        return paymentRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new RuntimeException("Payment not found."));
    }
}