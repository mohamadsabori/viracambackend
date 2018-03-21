package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 1/17/2018.
 */
@Entity(name = "T_CATEGORY")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "C_CODE")
    String code;
    @Column(name = "C_VALUE")
    String value;

    @JsonCreator
    public Category(@JsonProperty("id")long id,
                    @JsonProperty("code")String code,
                    @JsonProperty("value")String value) {
        this.id = id;
        this.code = code;
        this.value = value;
    }

    public Category(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
