package com.pairProject.payment.business.requests;


public class CustomerBalanceCreateRequest {

    private int customerId;
    private double balance;

    public CustomerBalanceCreateRequest() {
    }

    public CustomerBalanceCreateRequest(int customerId, double balance) {
        this.customerId = customerId;
        this.balance = balance;
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
