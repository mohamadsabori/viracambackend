package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohammad on 1/8/2018.
 */
@Entity(name = "T_PRODUCT")
public class Product implements Serializable {

    @Column(name = "C_DISCOUNTCONDITION")
    String discountCondition;
    @Column(name = "C_DISCOUNT")
    String discount;
    @Column(name = "C_NAME")
    String name;
    @Column(name = "C_COST")
    String cost;
    @Column(name = "C_DESCRIPTION")
    String description;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductImages> productImages;
    @Column(name = "C_PRODUCTCODE")
    private String productCode;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<ProductProperties> productProperties;

    @ManyToOne
    private ProductCategory category;
    @Column(name = "C_ENABLE")
    private boolean enable;

    @JsonCreator
    public Product(@JsonProperty("id") long id
            ,@JsonProperty("name") String name
            ,@JsonProperty("cost") String cost
            ,@JsonProperty("description") String description
            ,@JsonProperty("productCode") String productCode
            ,@JsonProperty("productProperties") Set<ProductProperties> productProperties
            ,@JsonProperty("category") ProductCategory category
            ,@JsonProperty("enable") boolean enable
            ,@JsonProperty("discountCondition") String discountCondition
            ,@JsonProperty("discount") String discount
            ) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.productCode = productCode;
        this.productProperties = productProperties;
        this.category = category;
        this.enable = enable;
        this.discount = discount;
        this.discountCondition = discountCondition;
    }

    public Product(String name
            , String cost
            , String description
            , List<ProductImages> productImages
            , String productCode
            , Set<ProductProperties> productProperties
            ,ProductCategory category
            ,String discountCondition
            ,String discount) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.productImages = productImages;
        this.productCode = productCode;
        this.productProperties = productProperties;
        this.category = category;
        this.discountCondition = discountCondition;
        this.discount = discount;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Set<ProductProperties> getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(Set<ProductProperties> productProperties) {
        this.productProperties = productProperties;
    }

    public Product(){

    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProductImages> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImages> productImages) {
        this.productImages = productImages;
    }

    public String getDiscountCondition() {
        return discountCondition;
    }

    public void setDiscountCondition(String discountCondition) {
        this.discountCondition = discountCondition;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
