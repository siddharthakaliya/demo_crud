package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderDTO {

    @Email

    @NotNull

    private String customerEmail;

    @NotNull

    @Positive
    private Double amount;

    public String getCustomerEmail() {
        return customerEmail;

    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;

    }

    public Double getAmount() {
        return amount;

    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}