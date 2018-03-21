package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by msabori on 1/28/18.
 */
@Entity(name = "T_PRODUCTPROPERTIES")
public class ProductProperties {
    @ManyToOne
    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "C_VALUE")
    private String value;

    public ProductProperties(@JsonProperty("id") long id
            ,@JsonProperty("product")Product product
            ,@JsonProperty("value") String value) {
        this.id = id;
        this.product = product;
        this.value = value;
    }

    public ProductProperties(Product product, String value) {
        this.product = product;
        this.value = value;
    }

    public ProductProperties() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
