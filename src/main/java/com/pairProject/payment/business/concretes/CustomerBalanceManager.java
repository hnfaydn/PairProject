package com.pairProject.payment.business.concretes;

import com.pairProject.payment.business.abstracts.CustomerBalanceService;
import com.pairProject.payment.business.abstracts.CustomerService;
import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CustomerBalanceCreateRequest;
import com.pairProject.payment.entities.concretes.CustomerBalance;

import java.util.ArrayList;
import java.util.List;

public class CustomerBalanceManager implements CustomerBalanceService {

    public List<CustomerBalance> customerBalances = new ArrayList<>();

    CustomerService customerService;

    public CustomerBalanceManager(CustomerService customerService) {
        this.customerService = customerService;

    }

    @Override
    public CustomerBalance add(CustomerBalanceCreateRequest customerBalanceCreateRequest) throws BusinessException {

        checkIfCustomerIdExists(customerBalanceCreateRequest.getCustomerId());

        CustomerBalance customerBalance = CustomerBalance.builder()
                .id(customerBalances.size()+1)
                .customerId(customerBalanceCreateRequest.getCustomerId())
                .balance(customerBalanceCreateRequest.getBalance())
                .build();

        customerBalances.add(customerBalance);

        return customerBalance;
    }

    private void checkIfCustomerIdExists(int customerId) throws BusinessException {
        customerService.getById(customerId);
    }

    @Override
    public CustomerBalance getById(int id) throws BusinessException {

        checkIfCustomerBalanceIdExists(id);

        return customerBalances.get(id-1);
    }

    private void checkIfCustomerBalanceIdExists(int id) throws BusinessException {

        if(customerBalances.get(id-1)==null){
            throw new BusinessException("There is no customer balance with following id: "+ id);
        }
    }

    @Override
    public List<CustomerBalance> getAll() {

        return customerBalances;
    }

    @Override
    public CustomerBalance getCustomerBalanceByCustomerId(int id) throws BusinessException {

        for (CustomerBalance customerBalance : customerBalances){
            if(customerBalance.getCustomerId()==id);
            return customerBalance;
        }

        throw new BusinessException("There is no balance for following customer id: " + id);
    }
}
