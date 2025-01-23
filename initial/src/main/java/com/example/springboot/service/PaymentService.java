package com.example.springboot.service;

import com.example.springboot.model.Payment;
import com.example.springboot.model.PaymentRequest;

public interface PaymentService {

    Payment processPayment(PaymentRequest paymentRequest);

    Payment getPaymentStatus(String transactionId);
}