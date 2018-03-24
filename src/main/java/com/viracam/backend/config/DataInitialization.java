package com.viracam.backend.config;

import com.viracam.backend.model.*;
import com.viracam.backend.services.StorageService;
import com.viracam.backend.services.category.CategoryService;
import com.viracam.backend.services.product.ProductsService;
import com.viracam.backend.services.productimages.ProductImagesSevice;
import com.viracam.backend.services.shippingmethod.ShippingMethodRepository;
import com.viracam.backend.services.systemusers.SystemUsersService;
import com.viracam.backend.util.CategoryCodes;
import org.hibernate.collection.internal.PersistentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mohammad on 8/31/2017.
 */
@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataInitialization.class);

    @Autowired
    ProductsService productsService;
    @Autowired
    SystemUsersService usersService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImagesSevice imagesSevice;
    @Autowired
    StorageService storageService;
    @Autowired
    ShippingMethodRepository shippingMethodRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (true) return;
        SystemUsers users = usersService.findByUserPhoneNumber("09124850689");
        if (users == null) {
            usersService.addUser(new SystemUsers("Mohamad", "09124850689"));
        }
        users = usersService.findByUserPhoneNumber("09123971861");
        if (users == null) {
            usersService.addUser(new SystemUsers("Ali", "09123971861"));
        }

        Category category = categoryService.findByCode(CategoryCodes.START_ORDER);
        if (category == null) {
            categoryService.addCategory(new Category(CategoryCodes.START_ORDER, "ثبت سفارش"));
        }
        category = categoryService.findByCode(CategoryCodes.CONFIRM_ORDER);
        if (category == null) {
            categoryService.addCategory(new Category(CategoryCodes.CONFIRM_ORDER, "تایید سفارش"));
        }

        new StorageService().init();


        ProductCategory productCategory = productsService.findProductCategoryByCode("AHD");
        if (productCategory == null) {
            productsService.saveProductCategory(new ProductCategory("AHD", "AHD"));
        }

        productCategory = productsService.findProductCategoryByCode("IP");
        if (productCategory == null) {
            productsService.saveProductCategory(new ProductCategory("IP", "IP"));
        }

        productCategory = productsService.findProductCategoryByCode("Accessories");
        if (productCategory == null) {
            productsService.saveProductCategory(new ProductCategory("Accessories", "Accessories"));
        }

        Product product = productsService.findByProductCode("324P");
        if (product == null) {
            productCategory = productsService.findProductCategoryByCode("AHD");
            product = productsService.addProduct(new Product("H42", "42000", "1 Mega Pixel\n" +
                    "3.6mm Lens\n" +
                    "Fiberglass Case\n" +
                    "LED Hidden\n" +
                    "UTC\n", Collections.EMPTY_LIST, "324P", Collections.EMPTY_SET, productCategory));
        }
        createProductImage(product);

        product = productsService.findByProductCode("D110");
        if (product == null) {
            productCategory = productsService.findProductCategoryByCode("AHD");
            product = productsService.addProduct(new Product("D110", "39000", "1 Mega Pixel\n" +
                    "2.8mm Lens\n" +
                    "Fiberglass Case\n" +
                    "LED Hidden\n" +
                    "UTC\n", Collections.EMPTY_LIST, "D110", Collections.EMPTY_SET, productCategory));
        }
        createProductImage(product);

        product = productsService.findByProductCode("DC100VDM");
        if (product == null) {
            productCategory = productsService.findProductCategoryByCode("Accessories");
            product = productsService.addProduct(new Product("Aptina", "70000", "1 Mega Pixel\n" +
                    "2.8mm Lens\n" +
                    "Fiberglass Case\n" +
                    "LED Hidden\n" +
                    "UTC\n", Collections.EMPTY_LIST, "DC100VDM", Collections.EMPTY_SET, productCategory));
        }
        createProductImage(product);

        ShippingMethod shippingMethod = shippingMethodRepository.findByCode("PEYK");
        if (shippingMethod == null) {
            shippingMethod = new ShippingMethod("PEYK", "پیک");
            shippingMethodRepository.save(shippingMethod);
        }

        shippingMethod = shippingMethodRepository.findByCode("TIPAKS");
        if (shippingMethod == null) {
            shippingMethod = new ShippingMethod("TIPAKS", "تیپاکس");
            shippingMethodRepository.save(shippingMethod);
        }

        shippingMethod = shippingMethodRepository.findByCode("BARBARY");
        if (shippingMethod == null) {
            shippingMethod = new ShippingMethod("BARBARY", "باربری");
            shippingMethodRepository.save(shippingMethod);
        }

        shippingMethod = shippingMethodRepository.findByCode("FOROSHGAH");
        if (shippingMethod == null) {
            shippingMethod = new ShippingMethod("FOROSHGAH", "فروشگاه");
            shippingMethodRepository.save(shippingMethod);
        }

        shippingMethod = shippingMethodRepository.findByCode("POST");
        if (shippingMethod == null) {
            shippingMethod = new ShippingMethod("POST", "پست");
            shippingMethodRepository.save(shippingMethod);
        }
    }

    private void createProductImage(Product product) {
        if (product.getProductImages() == null || product.getProductImages().size() == 0) {
            File file = new File(StorageService.rootLocation.toAbsolutePath() + "/HW-AD240VB-2-200x200.png");
            byte[] bFile = new byte[(int) file.length()];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                //convert file into array of bytes
                fileInputStream.read(bFile);
                fileInputStream.close();
                if (!Files.exists(Paths.get("upload-dir/" + product.getId()))) {
                    Files.createDirectory(Paths.get("upload-dir/" + product.getId()));
                }
                InputStream stream = new FileInputStream(file);
                if (!Files.exists(Paths.get("upload-dir/" + product.getId() + "/" + "HW-AD240VB-2-200x200.png"))) {
                    Files.copy(stream, StorageService.rootLocation.resolve(product.getId() + "/" + "HW-AD240VB-2-200x200.png"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            ProductImages productImage = new ProductImages(bFile, file.getPath());
            productImage = imagesSevice.add(productImage);
            if(product.getProductImages() == null){
                product.setProductImages(new ArrayList<ProductImages>());
            }
            product.getProductImages().add(productImage);
            productsService.updateProduct(product);
        }
        if (product.getProductProperties() == null || product.getProductProperties().size() == 0) {

            ProductProperties properties = new ProductProperties(product, "1 Mega Pixel");
            productsService.saveProductProperties(properties);
//            product.getProductProperties().add(properties);
//            productsService.updateProduct(product);

            properties = new ProductProperties(product, "2.8mm Lens");
            productsService.saveProductProperties(properties);
//            product.getProductProperties().add(properties);
//            productsService.updateProduct(product);

            properties = new ProductProperties(product, "Fiberglass Case");
            productsService.saveProductProperties(properties);
//            product.getProductProperties().add(properties);
//            productsService.updateProduct(product);

            properties = new ProductProperties(product, "LED Hidden");
            productsService.saveProductProperties(properties);
//            product.getProductProperties().add(properties);
//            productsService.updateProduct(product);

            properties = new ProductProperties(product, "UTC");
            productsService.saveProductProperties(properties);
//            product.getProductProperties().add(properties);
//            productsService.updateProduct(product);
        }
    }
}
