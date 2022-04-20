package com.pairProject.payment.business.abstracts;

import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CustomerBalanceCreateRequest;
import com.pairProject.payment.business.requests.CustomerCreateRequest;
import com.pairProject.payment.entities.concretes.CustomerBalance;

import java.util.List;

public interface CustomerBalanceService {

    CustomerBalance add(CustomerBalanceCreateRequest customerBalanceCreateRequest) throws BusinessException;

    CustomerBalance getById(int id) throws BusinessException;

    List<CustomerBalance> getAll();

    CustomerBalance getCustomerBalanceByCustomerId(int id) throws BusinessException;
}
