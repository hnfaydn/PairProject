package com.pairProject.payment.entities.concretes;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class Payment {
    private int id;
    private double total;
    private int customerId;
    private int transactionId;
    private LocalDate date;

    public Payment() {
    }

    public Payment(int id, double total, int customerId, int transactionId, LocalDate date) {
        this.id = id;
        this.total = total;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
