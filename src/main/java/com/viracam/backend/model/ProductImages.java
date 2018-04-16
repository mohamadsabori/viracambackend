package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 1/8/2018.
 */
@Entity(name = "T_PRODUCTIMAGES")
public class ProductImages implements Serializable {
    @Column(name = "C_FILENAME")
    private String filename;
    @Column(name = "C_PHOTO")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;
    @Id
    @Column(name = "C_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public ProductImages() {
    }

    public ProductImages(byte[] photo, String filename) {
        this.photo = photo;
        this.filename = filename;
    }

    public ProductImages( @JsonProperty("photo") byte[] photo
            , @JsonProperty("id") long id
            ,@JsonProperty("filename")String filename) {
        this.photo = photo;
        this.id = id;
        this.filename = filename;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
