package com.example.paymentgateway.service;

import com.example.paymentgateway.model.Payment;
import com.example.paymentgateway.model.PaymentRequest;

public interface PaymentService {

    Payment processPayment(PaymentRequest paymentRequest);

    Payment getPaymentStatus(String transactionId);
}