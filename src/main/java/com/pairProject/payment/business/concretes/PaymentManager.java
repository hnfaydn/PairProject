package com.pairProject.payment.business.concretes;

import com.pairProject.payment.business.abstracts.CreditCardService;
import com.pairProject.payment.business.abstracts.CustomerBalanceService;
import com.pairProject.payment.business.abstracts.CustomerService;
import com.pairProject.payment.business.abstracts.PaymentService;
import com.pairProject.payment.business.exception.BusinessException;
import com.pairProject.payment.business.requests.CustomerBalanceCreateRequest;
import com.pairProject.payment.business.requests.PaymentCreateRequest;
import com.pairProject.payment.entities.concretes.CreditCard;
import com.pairProject.payment.entities.concretes.Customer;
import com.pairProject.payment.entities.concretes.CustomerBalance;
import com.pairProject.payment.entities.concretes.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentManager implements PaymentService {

    public List<Payment> payments = new ArrayList<>();

    CustomerService customerService;
    CreditCardService creditCardService;
    CustomerBalanceService customerBalanceService;

    public PaymentManager(CustomerService customerService, CreditCardService creditCardService, CustomerBalanceService customerBalanceService) {
        this.customerService = customerService;
        this.creditCardService = creditCardService;
        this.customerBalanceService = customerBalanceService;
    }

    @Override
    public void add(PaymentCreateRequest paymentCreateRequest) throws BusinessException {

     Customer customer = customerService.add(paymentCreateRequest.getCustomerCreateRequest());
     CreditCard creditCard = creditCardService.add(paymentCreateRequest.getCreditCardCreateRequest());

     CustomerBalanceCreateRequest customerBalanceCreateRequest = new CustomerBalanceCreateRequest();
     customerBalanceCreateRequest.setCustomerId(customer.getId());
     customerBalanceCreateRequest.setBalance(paymentCreateRequest.getCustomerBalance());
     CustomerBalance customerBalance = customerBalanceService.add(customerBalanceCreateRequest);

     checkIfCustomerHasBalanceToPayment(customer,paymentCreateRequest.getTotal());

     Payment payment = new Payment();

     payment.setDate(LocalDate.now());
     payment.setCustomerId(customer.getId());
     payment.setTotal(paymentCreateRequest.getTotal());
     payment.setId(payments.size()+1);
     payment.setTransactionId(transactionIdCalculator(customer.getId(),payment));
     payments.add(payment);

    }

    private void checkIfCustomerHasBalanceToPayment(Customer customer, double total) throws BusinessException {
        if(customerBalanceService.getCustomerBalanceByCustomerId(customer.getId()).getBalance()<= total){
            throw new BusinessException("There is not enough balance to payment");
        }
    }

    private int transactionIdCalculator(int id, Payment payment) {
        return Integer.parseInt(id + payment.getDate().getYear() + payment.getDate().getMonth().toString() + payment.getDate().getDayOfMonth());
    }

    @Override
    public Payment getById(int id) throws BusinessException {

        checkIfPaymentIdExists(id);

        return payments.get(id-1);
    }

    private void checkIfPaymentIdExists(int id) throws BusinessException {
        if(payments.get(id-1)==null){
            throw new BusinessException("There is no customer with following id: "+ id);
        }
    }

    @Override
    public List<Payment> getAll() {

        return payments;
    }
}
