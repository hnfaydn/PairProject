package com.pairProject.payment.entities.concretes;

import lombok.Builder;

@Builder
public class CustomerBalance{
    private int id;
    private int customerId;
    private double balance;

    public CustomerBalance() {
    }

    public CustomerBalance(int id, int customerId, double balance) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}