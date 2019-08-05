package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.CustomerRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;


    public Customer signUp(Customer customer) {
        return repo.save(customer);
    }

    public Customer update(Long id, Customer updatedCustomer) {
        return repo.findById(id).map(customer -> {
            updatedCustomer.setId(id);
            return repo.save(updatedCustomer);
        }).orElse(
                repo.save(updatedCustomer)
        );
    }

    public Customer read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(Customer.class.getName(), id));
    }

    public void delete(Long id) throws ObjectNotFoundException {
        Customer customer = read(id);
        repo.delete(customer);
    }

    public List<Customer> readAll() {
        return repo.findAll();
    }


}
