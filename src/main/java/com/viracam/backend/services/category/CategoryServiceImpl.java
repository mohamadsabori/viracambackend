package com.viracam.backend.services.category;

import com.viracam.backend.model.Category;
import com.viracam.backend.model.Product;
import com.viracam.backend.repository.category.CategoryRepository;
import com.viracam.backend.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mohammad on 1/8/2018.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository repository;

    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return repository.save(category);
    }

    public Category getByCategoryCode(String code){
        return repository.findByCode(code);
    }

    @Override
    public Category findByCode(String code) {
        return repository.findByCode(code);
    }
}
