package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.CustomerRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.exeption.CustomerNotFoudException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repo;


    public CustomerService(CustomerRepository customerRepository) {
        this.repo = customerRepository;
    }
    public Customer signUp(Customer customer){
        return repo.save(customer);
    }
    public Customer update(Long customerId,Customer newCustomer) throws CustomerNotFoudException {
        Customer customer = findById(customerId);
        newCustomer.setId(customerId);
        return repo.save(newCustomer);
    }
    public Customer findById(Long id) throws CustomerNotFoudException {
        return repo.findById(id).orElseThrow(()->new CustomerNotFoudException(id));
    }
    public void delete(Long id) throws CustomerNotFoudException {
        Customer customer = findById(id);
         repo.delete(customer);
    }



}
