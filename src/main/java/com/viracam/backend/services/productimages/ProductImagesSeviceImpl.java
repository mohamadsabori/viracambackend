package com.viracam.backend.services.productimages;

import com.viracam.backend.model.Product;
import com.viracam.backend.model.ProductImages;
import com.viracam.backend.repository.productimages.ProductImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by msabori on 1/21/18.
 */
@Service
public class ProductImagesSeviceImpl implements ProductImagesSevice {

    @Autowired
    ProductImagesRepository repository;
    public ProductImages add(ProductImages productImages){
        return repository.save(productImages);
    }

}
