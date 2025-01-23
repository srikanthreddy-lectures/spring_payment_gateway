package com.example.paymentgateway.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PaymentRequest {

    @NotBlank(message = "Credit card number is required.")
    private String creditCardNumber;

    @NotBlank(message = "Card holder name is required.")
    private String cardHolderName;

    @NotBlank(message = "Expiration date is required.")
    private String expirationDate;

    @NotBlank(message = "CVV is required.")
    private String cvv;

    @NotNull(message = "Amount is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero.")
    private BigDecimal amount;

    // Getters and Setters
    // ...
}