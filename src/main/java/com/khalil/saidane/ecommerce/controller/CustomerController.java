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
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.signUp(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable Long id) throws ObjectNotFoundException {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        customerService.delete(id);
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) throws ObjectNotFoundException {
        return customerService.read(id);
    }

    @GetMapping("")
    public List<Customer> readAll() {
        return customerService.readAll();
    }



}
