package com.example.springboot.controller;

import com.example.springboot.model.Payment;
import com.example.springboot.model.PaymentRequest;
import com.example.springboot.service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/")
	public String index() {
		return "Payment gateway!";
	}

    // Check Payment Status
    @GetMapping("/{transactionId}")
    public ResponseEntity<Payment> getPaymentStatus(@PathVariable String transactionId) {
        Payment payment = paymentService.getPaymentStatus(transactionId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}