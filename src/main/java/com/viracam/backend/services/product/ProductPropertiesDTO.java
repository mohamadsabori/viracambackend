package com.viracam.backend.services.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by msabori on 1/28/18.
 */
public class ProductPropertiesDTO implements Serializable {
    private static final long serialVersionUID = 3L;
    private String value;
    private long id;

    @JsonCreator
    public ProductPropertiesDTO(@JsonProperty("value")String value
            ,@JsonProperty("id") long id) {
        this.value = value;
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
