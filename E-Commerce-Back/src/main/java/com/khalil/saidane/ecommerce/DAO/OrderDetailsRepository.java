package com.khalil.saidane.ecommerce.DAO;

import com.khalil.saidane.ecommerce.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
