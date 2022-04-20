package com.pairProject.payment.business.concretes;

import com.pairProject.payment.business.abstracts.CustomerService;
import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CustomerCreateRequest;
import com.pairProject.payment.entities.concretes.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements CustomerService {

    public List<Customer> customers = new ArrayList<>();

    public CustomerManager() {
    }

    @Override
    public Customer add(CustomerCreateRequest customerCreateRequest) {
        Customer customer = Customer.builder()
                .id(customers.size()+1)
                .firstName(customerCreateRequest.getFirstName())
                .lastName(customerCreateRequest.getLastName())
                .build();

        customers.add(customer);

        return customer;
    }

    @Override
    public Customer getById(int id) throws BusinessException {

        checkIfCustomerIdExists(id);
        return customers.get(id-1);
    }

    private void checkIfCustomerIdExists(int id) throws BusinessException {

        if(customers.get(id-1)==null){
            throw new BusinessException("There is no customer with following id: "+ id);
        }
    }

    @Override
    public List<Customer> getAll() {

        return customers;
    }
}
