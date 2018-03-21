package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by msabori on 1/31/18.
 */
@Entity(name = "T_ShippingMethod")
public class ShippingMethod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "C_CODE")
    String code;
    @Column(name = "C_VALUE")
    String value;

    @JsonCreator
    public ShippingMethod(@JsonProperty("code")String code
            ,@JsonProperty("value") String value
            ,@JsonProperty("id") long id) {
        this.code = code;
        this.value = value;
        this.id = id;
    }

    public ShippingMethod(String code
            ,String value) {
        this.code = code;
        this.value = value;
    }

    public ShippingMethod() {
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
