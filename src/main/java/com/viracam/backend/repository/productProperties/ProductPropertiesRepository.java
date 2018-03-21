package com.viracam.backend.repository.productProperties;

import com.viracam.backend.model.Product;
import com.viracam.backend.model.ProductProperties;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by msabori on 1/28/18.
 */
public interface ProductPropertiesRepository extends CrudRepository<ProductProperties,Long> {
    Set<ProductProperties> findByProduct(Product product);
}
