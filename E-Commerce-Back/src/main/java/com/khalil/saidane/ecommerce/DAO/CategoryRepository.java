package com.khalil.saidane.ecommerce.DAO;


import com.khalil.saidane.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
