package com.pairProject.payment.business.concretes;

import com.pairProject.payment.business.abstracts.CreditCardService;
import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CreditCardCreateRequest;
import com.pairProject.payment.entities.concretes.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardManager implements CreditCardService {

    public List<CreditCard> creditCards = new ArrayList<>();

    public CreditCardManager(){

    }

    @Override
    public CreditCard add(CreditCardCreateRequest creditCardCreateRequest) {

        CreditCard creditCard = CreditCard.builder()
                .cardHolder(creditCardCreateRequest.getCardHolder())
                .cardNumber(creditCardCreateRequest.getCardNumber())
                .csv(creditCardCreateRequest.getCsv())
                .expiration(creditCardCreateRequest.getExpiration())
                .build();

        creditCards.add(creditCard);

        return creditCard;
    }

    @Override
    public CreditCard getById(String cardNumber) throws BusinessException {

        for (CreditCard currentCreditCard : creditCards){
            if(currentCreditCard.getCardNumber().equals(cardNumber)){
                return currentCreditCard;
            }
        }
        throw new BusinessException("There is no card with following number: " + cardNumber);
    }

    @Override
    public List<CreditCard> getAll() {

        return creditCards;
    }
}
