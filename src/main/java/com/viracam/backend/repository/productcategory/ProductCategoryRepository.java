package com.viracam.backend.repository.productcategory;

import com.viracam.backend.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by msabori on 1/28/18.
 */
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
    ProductCategory findByCode(String code);
}
