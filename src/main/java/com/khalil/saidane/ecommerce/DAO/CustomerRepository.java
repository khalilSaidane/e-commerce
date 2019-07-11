package com.khalil.saidane.ecommerce.DAO;

import com.khalil.saidane.ecommerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
