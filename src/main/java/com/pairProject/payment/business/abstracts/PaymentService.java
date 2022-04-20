package com.pairProject.payment.business.abstracts;

import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CustomerCreateRequest;
import com.pairProject.payment.business.requests.PaymentCreateRequest;
import com.pairProject.payment.entities.concretes.Payment;

import java.util.List;

public interface PaymentService {

    void add(PaymentCreateRequest paymentCreateRequest) throws BusinessException;

    Payment getById(int id) throws BusinessException;

    List<Payment> getAll();
}
