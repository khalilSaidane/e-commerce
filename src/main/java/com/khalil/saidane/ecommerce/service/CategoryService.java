package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.CategoryRepository;
import com.khalil.saidane.ecommerce.entities.Category;
import com.khalil.saidane.ecommerce.entities.Product;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private  CategoryRepository repo;
    @Autowired
    private  ProductService productService;



    public Category read(Long id) throws ObjectNotFoundException {
        return repo.findById(id).orElseThrow(()-> new ObjectNotFoundException(Category.class.getName(),id));
    }

    public Category create(Category c){
        return repo.save(c);
    }

    public Category update(Long id,Category newCategory)  {
        return repo.findById(id).map(category -> {
           newCategory.setId(id);
           return repo.save(newCategory);
        }).orElse(
                repo.save(newCategory)
        );
    }
    public void delete (Long id) throws ObjectNotFoundException {
        Category c = read(id);
        repo.delete(c);
    }
    public Category affectCategoryToProduct(Long category_id,Long product_id) throws ObjectNotFoundException {
        Category category = read(category_id);
        Product product = productService.read(product_id);
        category.setProduct(product);
        return repo.save(category);
    }

    public List<Category> readAll() {
        return repo.findAll();
    }
}
