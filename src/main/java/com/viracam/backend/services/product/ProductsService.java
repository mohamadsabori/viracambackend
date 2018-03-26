package com.viracam.backend.services.product;

import com.viracam.backend.model.Product;
import com.viracam.backend.model.ProductCategory;
import com.viracam.backend.model.ProductProperties;
import com.viracam.backend.model.ShippingMethod;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Mohammad on 1/15/2018.
 */
public interface ProductsService {
    public Iterable<Product> findAll();
    public Product addProduct(Product product);
    void addNewProductPicture();
    Product findOne(long productId);
    public Resource getFile(String filename);
    public void store(MultipartFile file,long productId);
    ProductDTO loadProduct(long productId);
    Product findByProductCode(String code);
    ProductProperties saveProductProperties(ProductProperties properties);
    Set<ProductProperties> findByProduct(Product product);
    ProductCategory findProductCategoryByCode(String code);
    ProductCategory saveProductCategory(ProductCategory productCategory);
    Iterable<ProductCategory> loadAllProductTypes();
    ArrayList<ProductDTO> getAllProductsByCategoryType(long selectedCategory);
    ArrayList<ProductDTO> loadAllProductsForClient();
    Iterable<ShippingMethod> loadAllshippingMethods();
    Product updateProduct(Product newProduct);

    Product addProductWithoutImages(Product product);

    Product loadProductById(long productId);
}
