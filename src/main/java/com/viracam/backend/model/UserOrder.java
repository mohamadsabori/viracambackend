package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by msabori on 1/31/18.
 */
@Entity(name = "T_UserOrder")
public class UserOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private Set<ProductOrder> orderset;
    @Column(name = "C_USERFULLNAME")
    private String userFullName;
    @Column(name = "C_USERPHONENUMBER")
    private String userPhoneNumber;
    @Column(name = "C_USERADDRESS")
    private String userAddress;
    @ManyToOne
    private ShippingMethod shippingMethod;

    @JsonCreator
    public UserOrder(@JsonProperty("id")long id
            ,@JsonProperty("orderset")Set<ProductOrder> orderset
            ,@JsonProperty("userFullName") String userFullName
            ,@JsonProperty("userPhoneNumber") String userPhoneNumber
            ,@JsonProperty("userAddress") String userAddress
            ,@JsonProperty("shippingMethod") ShippingMethod shippingMethod) {
        this.id = id;
        this.orderset = orderset;
        this.userFullName = userFullName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.shippingMethod = shippingMethod;
    }

    public UserOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<ProductOrder> getOrderset() {
        return orderset;
    }

    public void setOrderset(Set<ProductOrder> orderset) {
        this.orderset = orderset;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
