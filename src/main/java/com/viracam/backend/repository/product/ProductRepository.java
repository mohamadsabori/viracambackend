package com.viracam.backend.repository.product;

import com.viracam.backend.model.Product;
import com.viracam.backend.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mohammad on 1/8/2018.
 */
public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findByProductCode(String code);

    Iterable<Product> findByCategoryAndEnable(ProductCategory category,boolean enable);
    Iterable<Product> findByEnable(boolean enable);
}
