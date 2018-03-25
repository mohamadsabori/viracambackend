package com.viracam.backend.services.product;

import com.viracam.backend.model.*;
import com.viracam.backend.services.productimages.ProductImagesSevice;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Mohammad on 1/8/2018.
 */
@RestController
@RequestMapping(value = "product", produces = "application/hal+json;charset=UTF-8")
public class ProductController {
    @Autowired
    ProductsService service;
    @Autowired
    ProductImagesSevice imagesSevice;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "loadAllProducts", method = RequestMethod.GET)
    public Iterable<Product> loadAllCredit() {
        return service.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Product addProductPost(@RequestBody Product product) {
        return service.addProductWithoutImages(product);
    }

    @RequestMapping(value = "/add/image", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity upload(@RequestParam("id") long productId, HttpServletResponse response, HttpServletRequest request) {
        try {
            Product product = service.findOne(productId);
            StandardMultipartHttpServletRequest request1 = (StandardMultipartHttpServletRequest) request;
            MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
            while (multipart.getFileNames().hasNext()){
                Iterator<String> it = multipart.getFileNames();
                MultipartFile files = multipart.getFile(it.next());
                String fileName = productId + ".png";
                byte[] bytes = files.getBytes();
                service.store(files, product.getId());
            /*BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("/src/main/resources/static/images/product" + fileName)));
            stream.write(bytes);
            stream.close();*/
                // Saving to data base
                ProductImages productImage = new ProductImages(bytes, product.getId() + "/" + files.getOriginalFilename());
                productImage = imagesSevice.add(productImage);
                product.getProductImages().add(productImage);
                service.updateProduct(product);
                return new ResponseEntity("Upload success!", HttpStatus.OK);
            }
            return new ResponseEntity("No File to upload!", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "files", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFile(@RequestParam("id") long productId, @RequestParam("filename") String fileName) {
        Resource file = service.getFile(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping(path = "loadAllProductsForClient", method = RequestMethod.GET)
    public ArrayList<ProductDTO> loadAllProductsForClient() {
        return service.loadAllProductsForClient();
    }

    @RequestMapping(path = "loadProduct", method = RequestMethod.GET)
    public ProductDTO loadProduct(@RequestParam("id") long productId) {
        return service.loadProduct(productId);
    }

    @RequestMapping(path = "loadProductById", method = RequestMethod.GET)
    public ProductDTO loadProductById(@RequestParam("id") long productId) {
        return service.loadProduct(productId);
    }

    @RequestMapping(path = "loadAllProductTypes", method = RequestMethod.GET)
    public Iterable<ProductCategory> loadAllProductTypes() {
        return service.loadAllProductTypes();
    }

    @RequestMapping(path = "loadAllProductsForClientByCategoryType/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<ProductDTO> loadAllProductsForClientByCategoryType(@RequestBody @PathVariable("id") long selectedCategory) {
        return service.getAllProductsByCategoryType(selectedCategory);
    }

    @RequestMapping(path = "loadAllshippingMethods", method = RequestMethod.GET)
    public Iterable<ShippingMethod> loadAllshippingMethods() {
        return service.loadAllshippingMethods();
    }
}
