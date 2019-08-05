package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.CustomerRepository;
import com.khalil.saidane.ecommerce.entities.Customer;
import com.khalil.saidane.ecommerce.entities.Order_;
import com.khalil.saidane.ecommerce.exeption.EmailAlreadyUsedException;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository repo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public Customer signUp(Customer customer) throws EmailAlreadyUsedException {
        try {
            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
            return repo.save(customer);
        }catch (Exception e){
            throw new EmailAlreadyUsedException(customer.getEmail());
        }
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


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         Customer customer =  repo.findCustomerByEmail(email);
         if(customer == null ) throw new UsernameNotFoundException(email);
         return new User(customer.getEmail(),customer.getPassword(),new ArrayList<>());
    }
}
