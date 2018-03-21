package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by msabori on 1/28/18.
 */
@Entity(name = "T_PRODUCTCATEGORY")
public class ProductCategory {
    @Column(name = "C_CATEGORYNAME")
    private String categoryName;
    @Column(name = "C_CODE")
    private String code;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonCreator
    public ProductCategory(@JsonProperty("categoryName") String categoryName
            ,@JsonProperty("code") String code
            ,@JsonProperty("id") long id) {
        this.categoryName = categoryName;
        this.code = code;
        this.id = id;
    }

    public ProductCategory(String categoryName, String code) {
        this.categoryName = categoryName;
        this.code = code;
    }

    public ProductCategory() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
