package com.khalil.saidane.ecommerce.DAO;

import com.khalil.saidane.ecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {
    Customer findCustomerByEmail(String email);
}
