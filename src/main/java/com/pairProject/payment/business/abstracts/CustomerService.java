package com.pairProject.payment.business.abstracts;

import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CustomerCreateRequest;
import com.pairProject.payment.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(CustomerCreateRequest customerCreateRequest);

    Customer getById(int id) throws BusinessException;

    List<Customer> getAll();
}
