package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.ProductRepository;
import com.khalil.saidane.ecommerce.entities.Product;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;


    public Product read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(Product.class.getName(), id));
    }

    public Product create(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product updatedProduct) {
        return repo.findById(id).map(product -> {
            updatedProduct.setId(id);
            return repo.save(updatedProduct);
        }).orElse(
                repo.save(updatedProduct)
        );
    }

    public void delete(Long id) throws ObjectNotFoundException {
        Product p = read(id);
        repo.delete(p);
    }

    public List<Product> readAll() {
        return repo.findAll();
    }


}
