package com.viracam.backend.repository.productimages;

import com.viracam.backend.model.Product;
import com.viracam.backend.model.ProductImages;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by Mohammad on 1/17/2018.
 */
public interface ProductImagesRepository extends CrudRepository<ProductImages,Long> {
}
