package com.khalil.saidane.ecommerce.DAO;

import com.khalil.saidane.ecommerce.entities.Order_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order_,Long> {
}
