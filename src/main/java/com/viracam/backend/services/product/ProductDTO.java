package com.viracam.backend.services.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.viracam.backend.model.ProductProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by msabori on 1/23/18.
 */
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 2L;
    private String title;
    private String fileSource;
    private String note;
    private long id;
    private String cost;
    private ArrayList<ProductPropertiesDTO> properties;


    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonCreator
    public ProductDTO(@JsonProperty("title")String title
            , @JsonProperty("fileSource")String fileSource
            , @JsonProperty("note")String note
            ,@JsonProperty("id")long id
            ,@JsonProperty("cost")String cost
            ,@JsonProperty("properties")Set<ProductProperties> properties) {
        this.title = title;
        this.fileSource = fileSource;
        this.note = note;
        this.id = id;
        this.cost = cost;
        this.properties = new ArrayList<ProductPropertiesDTO>();
        for (ProductProperties property : properties) {
            this.properties.add(new ProductPropertiesDTO(property.getValue(),property.getId()));
        }
    }

    public ProductDTO() {
    }

    public ArrayList<ProductPropertiesDTO> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<ProductPropertiesDTO> properties) {
        this.properties = properties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
