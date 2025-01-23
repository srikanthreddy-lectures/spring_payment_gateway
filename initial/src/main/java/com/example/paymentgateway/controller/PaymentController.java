package com.example.paymentgateway.controller;

import com.example.paymentgateway.model.Payment;
import com.example.paymentgateway.model.PaymentRequest;
import com.example.paymentgateway.service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Initiate Payment
    @PostMapping
    public ResponseEntity<Payment> initiatePayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.processPayment(paymentRequest);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    // Check Payment Status
    @GetMapping("/{transactionId}")
    public ResponseEntity<Payment> getPaymentStatus(@PathVariable String transactionId) {
        Payment payment = paymentService.getPaymentStatus(transactionId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}