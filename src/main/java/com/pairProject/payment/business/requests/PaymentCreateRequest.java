package com.pairProject.payment.business.requests;

public class PaymentCreateRequest {

    private CustomerCreateRequest customerCreateRequest;

    private CreditCardCreateRequest creditCardCreateRequest;

    private double customerBalance;

    private double total;

    public PaymentCreateRequest() {
    }

    public PaymentCreateRequest(CustomerCreateRequest customerCreateRequest, CreditCardCreateRequest creditCardCreateRequest, double customerBalance, double total) {
        this.customerCreateRequest = customerCreateRequest;
        this.creditCardCreateRequest = creditCardCreateRequest;
        this.customerBalance = customerBalance;
        this.total = total;
    }

    public CustomerCreateRequest getCustomerCreateRequest() {
        return customerCreateRequest;
    }

    public void setCustomerCreateRequest(CustomerCreateRequest customerCreateRequest) {
        this.customerCreateRequest = customerCreateRequest;
    }

    public CreditCardCreateRequest getCreditCardCreateRequest() {
        return creditCardCreateRequest;
    }

    public void setCreditCardCreateRequest(CreditCardCreateRequest creditCardCreateRequest) {
        this.creditCardCreateRequest = creditCardCreateRequest;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
