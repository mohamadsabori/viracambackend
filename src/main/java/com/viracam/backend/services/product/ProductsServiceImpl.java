package com.viracam.backend.services.product;

import com.viracam.backend.model.*;
import com.viracam.backend.repository.product.ProductRepository;
import com.viracam.backend.repository.productProperties.ProductPropertiesRepository;
import com.viracam.backend.repository.productcategory.ProductCategoryRepository;
import com.viracam.backend.repository.productimages.ProductImagesRepository;
import com.viracam.backend.services.StorageService;
import com.viracam.backend.services.shippingmethod.ShippingMethodRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Mohammad on 1/8/2018.
 */
@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductImagesRepository imagesRepository;
    @Autowired
    StorageService storageService;
    @Autowired
    ProductPropertiesRepository propertiesRepository;
    @Autowired
    ProductCategoryRepository categoryRepository;
    @Autowired
    ShippingMethodRepository shippingMethodRepository;


    Logger log = Logger.getLogger(this.getClass().getName());

    public Iterable<Product> findAll() {
        Iterable<Product> products = repository.findAll();
        ArrayList<Product> list = new ArrayList<Product>();
        for (Product product : products) {
            Product product1 = product;

            /*for (ProductImages productImage : product1.getProductImages()) {
                ProductImages images = new ProductImages();
                images.setFilename(productImage.getFilename());
                product1.getProductImages().add(images);
            }*/

            list.add(product1);        }
        return list;
    }

    public Product addProduct(Product product) {
        Product product1 = repository.save(product);
        return repository.findOne(product1.getId());
    }

    @Override
    public void addNewProductPicture() {

    }

    @Override
    public Product findOne(long productId) {
        return repository.findOne(productId);
    }

    @Override
    public Resource getFile(String filename) {
        return storageService.loadFile(filename);
    }

    public void store(MultipartFile file, long productId) {
        storageService.store(file, productId);
    }

    @Override
    public ProductDTO loadProduct(long productId) {
        Product product = repository.findOne(productId);
        ArrayList<ProductDTO> dtos = new ArrayList<ProductDTO>();
        ProductDTO dto = new ProductDTO();
        for (ProductImages image : product.getProductImages()) {
            dto = new ProductDTO(product.getName(), image.getFilename(), product.getDescription(), product.getId(), product.getCost(), product.getProductProperties());
            break;
        }
        return dto;
    }

    @Override
    public Product findByProductCode(String code) {
        Product product = repository.findByProductCode(code);
        return product;
    }

    @Override
    public ProductProperties saveProductProperties(ProductProperties properties) {
        return propertiesRepository.save(properties);
    }

    @Override
    public Set<ProductProperties> findByProduct(Product product) {
        return propertiesRepository.findByProduct(product);
    }

    @Override
    public ProductCategory findProductCategoryByCode(String code) {
        return categoryRepository.findByCode(code);
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }

    @Override
    public Iterable<ProductCategory> loadAllProductTypes() {
        return categoryRepository.findAll();
    }

    @Override
    public ArrayList<ProductDTO> getAllProductsByCategoryType(long selectedCategory) {
        ProductCategory category = categoryRepository.findOne(selectedCategory);
        Iterable<Product> products = repository.findByCategory(category);
        return createProductDTOS(products);
    }

    @Override
    public ArrayList<ProductDTO> loadAllProductsForClient() {
        Iterable<Product> products = repository.findAll();
        return createProductDTOS(products);
    }

    @Override
    public Iterable<ShippingMethod> loadAllshippingMethods() {
        return shippingMethodRepository.findAll();
    }

    private ArrayList<ProductDTO> createProductDTOS(Iterable<Product> products){
        ArrayList<ProductDTO> dtos = new ArrayList<ProductDTO>();
        for (Product product : products) {
            Hibernate.initialize(product.getProductProperties());
            ProductDTO dto = new ProductDTO();
            for (ProductImages image : product.getProductImages()) {
                Set<ProductProperties> properties = propertiesRepository.findByProduct(product);
                dto = new ProductDTO(product.getName(), image.getFilename(), product.getDescription(), product.getId(), product.getCost(), properties);
                break;
            }
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Product updateProduct(Product newProduct){
        return repository.save(newProduct);
    }

    @Override
    public Product addProductWithoutImages(Product product) {
        product.setProductImages(null);
        Set<ProductProperties> properties = new HashSet<ProductProperties>();
        for (ProductProperties productProperties : product.getProductProperties()) {
            properties.add(propertiesRepository.save(productProperties));
        }
        product.setProductProperties(properties);
        return addProduct(product);
    }
}
