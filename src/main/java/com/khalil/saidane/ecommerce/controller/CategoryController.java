package com.khalil.saidane.ecommerce.controller;

import com.khalil.saidane.ecommerce.entities.Category;
import com.khalil.saidane.ecommerce.exeption.ObjectNotFoundException;
import com.khalil.saidane.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("category-management")
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;


    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @GetMapping("{id}")
    public Category read(@PathVariable Long id) throws ObjectNotFoundException {
        return categoryService.read(id);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable Long id,Category updatedCategory){
        return categoryService.update(id,updatedCategory);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws ObjectNotFoundException {
        categoryService.delete(id);
    }

    @GetMapping
    private List<Category> readAll(){
        return categoryService.readAll();
    }
}
