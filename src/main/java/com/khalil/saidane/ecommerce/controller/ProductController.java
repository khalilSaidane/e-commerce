package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.Product;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-management")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @RequestMapping("{id}")
    public Product read(@PathVariable Long id) throws ObjectNotFoundException {
        return productService.read(id);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable Long id,@RequestBody Product updatedProduct){
        return productService.update(id,updatedProduct);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        productService.delete(id);
    }

    @GetMapping
    public List<Product> readAll(){
        return productService.readAll();
    }


}
