package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.CustomerRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;


    public CustomerService(CustomerRepository customerRepository) {
        this.repo = customerRepository;
    }

    public Customer signUp(Customer customer) {
        return repo.save(customer);
    }

    public Customer update(Long id, Customer newCustomer) throws ObjectNotFoundException {
        Customer customer = read(id);
        newCustomer.setId(id);
        return repo.save(newCustomer);
    }

    public Customer read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void delete(Long id) throws ObjectNotFoundException {
        Customer customer = read(id);
        repo.delete(customer);
    }

    public List<Customer> readAll() {
        return repo.findAll();
    }


}
