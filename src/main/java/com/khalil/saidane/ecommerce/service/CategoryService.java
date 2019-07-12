package com.khalil.saidane.ecommerce.service;

import com.khalil.saidane.ecommerce.DAO.CategoryRepository;
import com.khalil.saidane.ecommerce.entities.Category;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

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
}
