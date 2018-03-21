package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 1/17/2018.
 */
@Entity(name = "T_PRODUCTORDER")
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @OneToOne
//    @Column(name = "C_PRODUCT")
    Product product;
    @OneToOne
//    @Column(name = "C_USER")
    SystemUsers user;
    @Column(name = "C_ORDERDATE")
    String orderDate;
    @Column(name = "C_ORDERTIME")
    String orderTime;
    @OneToOne
//    @Column(name = "C_ORDERSTATUS")
    Category orderStatus;
    @ManyToOne
    UserOrder userOrder;


    @JsonCreator
    public ProductOrder(@JsonProperty("id")long id,
                        @JsonProperty("product")Product product,
                        @JsonProperty("user")SystemUsers user,
                        @JsonProperty("orderDate")String orderDate,
                        @JsonProperty("orderTime")String orderTime,
                        @JsonProperty("orderStatus")Category orderStatus,
                        @JsonProperty("userOrder")UserOrder userOrder) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.userOrder = userOrder;
    }

    public ProductOrder(Product product, SystemUsers user, String orderDate, String orderTime, Category orderStatus,UserOrder userOrder) {
        this.product = product;
        this.user = user;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.userOrder = userOrder;
    }

    public ProductOrder() {
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SystemUsers getUser() {
        return user;
    }

    public void setUser(SystemUsers user) {
        this.user = user;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Category getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Category orderStatus) {
        this.orderStatus = orderStatus;
    }
}
