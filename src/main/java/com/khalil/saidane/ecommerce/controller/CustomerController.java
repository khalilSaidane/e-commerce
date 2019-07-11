package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.CustomerService;
import com.khalil.saidane.ecommerce.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer-management")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public Customer signUp(@RequestBody Customer customer){
       return customerService.signUp(customer);
    }
    @GetMapping("/test")
    public String test(){
        return "success";
    }

}
