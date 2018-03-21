package com.viracam.backend.repository.category;

import com.viracam.backend.model.Category;
import com.viracam.backend.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mohammad on 1/8/2018.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Category findByCode(String code);
}
