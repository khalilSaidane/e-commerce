package com.khalil.saidane.ecommerce.DAO;

import com.khalil.saidane.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
