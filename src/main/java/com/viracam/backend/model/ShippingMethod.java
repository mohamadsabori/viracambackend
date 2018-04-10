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
    @Column(name = "C_HASDETAILADDRESS")
    boolean hasDetailAddress;

    @JsonCreator
    public ShippingMethod(@JsonProperty("code")String code
            ,@JsonProperty("value") String value
            ,@JsonProperty("id") long id
            ,@JsonProperty("hasDetailAddress") boolean hasDetailAddress) {
        this.code = code;
        this.value = value;
        this.id = id;
        this.hasDetailAddress = hasDetailAddress;
    }

    public boolean isHasDetailAddress() {
        return hasDetailAddress;
    }

    public void setHasDetailAddress(boolean hasDetailAddress) {
        this.hasDetailAddress = hasDetailAddress;
    }

    public ShippingMethod(String code
            , String value
            , boolean hasDetailAddress) {
        this.code = code;
        this.value = value;
        this.hasDetailAddress = hasDetailAddress;
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
