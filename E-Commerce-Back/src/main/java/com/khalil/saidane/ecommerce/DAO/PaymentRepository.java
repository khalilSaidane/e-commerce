package com.khalil.saidane.ecommerce.DAO;

import com.khalil.saidane.ecommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
