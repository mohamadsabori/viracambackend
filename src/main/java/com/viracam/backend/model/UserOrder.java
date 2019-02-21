package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    @Column(name = "C_TOTALFACTOR")
    BigDecimal totalFactor;
    @Column(name = "C_ORDERDATE")
    String orderDate;
    @Column(name = "C_ORDERTIME")
    String orderTime;
    @Column(name = "C_ORDERSERIAL")
    String orderSerial;
    @Column(name = "C_SHIPPINGMETHODDETAILS")
    String shippingMethodDetails;
    @OneToOne
//    @Column(name = "C_ORDERSTATUS")
    Category orderStatus;
    @Column(name = "C_ORDERPAYDATE")
    private String orderPayDate;
    @Column(name = "C_ORDERPAYTIME")
    private String orderPayTime;
    @Column(name = "C_REFID")
    private String refID;


    @JsonCreator
    public UserOrder(@JsonProperty("id")long id
            ,@JsonProperty("orderset")Set<ProductOrder> orderset
            ,@JsonProperty("userFullName") String userFullName
            ,@JsonProperty("userPhoneNumber") String userPhoneNumber
            ,@JsonProperty("userAddress") String userAddress
            ,@JsonProperty("shippingMethod") ShippingMethod shippingMethod
            ,@JsonProperty("totalFactor")BigDecimal totalFactor
            ,@JsonProperty("orderDate")String orderDate
            ,@JsonProperty("orderTime")String orderTime
            ,@JsonProperty("orderStatus")Category orderStatus
            ,@JsonProperty("orderSerial")String orderSerial
            ,@JsonProperty("shippingMethodDetails")String shippingMethodDetails
            ,@JsonProperty("orderPayDate")String orderPayDate
            ,@JsonProperty("orderPayTime")String orderPayTime
            ,@JsonProperty("refID")String refID
    ) {
        System.out.println("UserOrder initiated");
        this.id = id;
        this.orderset = orderset;
        this.userFullName = userFullName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.shippingMethod = shippingMethod;
        this.totalFactor = totalFactor;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.orderSerial = orderSerial;
        this.shippingMethodDetails = shippingMethodDetails;
        this.orderPayTime = orderPayTime;
        this.orderPayDate = orderPayDate;
        this.refID = refID;
    }

    public String getShippingMethodDetails() {
        return shippingMethodDetails;
    }

    public void setShippingMethodDetails(String shippingMethodDetails) {
        this.shippingMethodDetails = shippingMethodDetails;
    }

    public String getOrderSerial() {
        return orderSerial;
    }

    public void setOrderSerial(String orderSerial) {
        this.orderSerial = orderSerial;
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

    public UserOrder() {
    }

    public BigDecimal getTotalFactor() {
        return totalFactor;
    }

    public void setTotalFactor(BigDecimal totalFactor) {
        this.totalFactor = totalFactor;
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

    public void setOrderPayDate(String orderPayDate) {
        this.orderPayDate = orderPayDate;
    }

    public String getOrderPayDate() {
        return orderPayDate;
    }

    public void setOrderPayTime(String orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public String getOrderPayTime() {
        return orderPayTime;
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }
}
