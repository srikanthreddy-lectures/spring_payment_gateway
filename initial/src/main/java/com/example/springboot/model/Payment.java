package com.example.springboot.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private String transactionId;
    private PaymentRequest paymentRequest;
    private String status;
    private LocalDateTime timestamp;

    public Payment(PaymentRequest paymentRequest, String status) {
        this.transactionId = UUID.randomUUID().toString();
        this.paymentRequest = paymentRequest;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getter and Setter for transactionId
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    // Getter and Setter for paymentRequest
    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }

    // Getter and Setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and Setter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}