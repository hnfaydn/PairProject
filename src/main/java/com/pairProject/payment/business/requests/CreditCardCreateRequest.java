package com.pairProject.payment.business.requests;

public class CreditCardCreateRequest {
    private String cardHolder;
    private String cardNumber;
    private String csv;
    private String expiration;

    public CreditCardCreateRequest() {
    }

    public CreditCardCreateRequest(String cardHolder, String cardNumber, String csv, String expiration) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.csv = csv;
        this.expiration = expiration;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCsv() {
        return csv;
    }

    public void setCsv(String csv) {
        this.csv = csv;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
