package com.viracam.backend.services.productorder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 * Created by msabori on 1/20/18.
 */
public class AddOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    long productId;
    String userPhoneNumber;

    @JsonCreator
    public AddOrderDTO(@JsonProperty("productId")long productId, @JsonProperty("userPhoneNumber")String userPhoneNumber
    ) {
        this.productId = productId;
        this.userPhoneNumber = userPhoneNumber;
    }

    public AddOrderDTO() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
