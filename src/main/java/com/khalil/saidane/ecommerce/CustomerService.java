package com.khalil.saidane.ecommerce;

import com.khalil.saidane.ecommerce.DAO.CustomerRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
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

}
