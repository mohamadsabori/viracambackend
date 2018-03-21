package com.viracam.backend.services.category;

import com.viracam.backend.model.Category;
import com.viracam.backend.model.Product;

/**
 * Created by Mohammad on 1/15/2018.
 */
public interface CategoryService {
    public Iterable<Category> findAll();
    public Category addCategory(Category category);
    public Category getByCategoryCode(String code);


    Category findByCode(String code);
}
