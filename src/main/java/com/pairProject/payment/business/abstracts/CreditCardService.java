package com.pairProject.payment.business.abstracts;

import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CreditCardCreateRequest;
import com.pairProject.payment.business.requests.CustomerCreateRequest;
import com.pairProject.payment.entities.concretes.CreditCard;

import java.util.List;

public interface CreditCardService {

    CreditCard add(CreditCardCreateRequest creditCardCreateRequest);

    CreditCard getById(String cardNumber) throws BusinessException;

    List<CreditCard> getAll();
}
