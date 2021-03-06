package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.CustomerService;
import com.khalil.saidane.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer-management")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.signUp(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer updatedCustomer, @PathVariable Long id) throws ObjectNotFoundException {
        return customerService.update(id, updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    public Customer read(@PathVariable Long id) throws ObjectNotFoundException {
        return customerService.read(id);
    }

    @GetMapping
    public List<Customer> readAll() {
        return customerService.readAll();
    }


}
