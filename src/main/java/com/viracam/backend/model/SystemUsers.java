package com.viracam.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 1/17/2018.
 */
@Entity(name = "T_SYSTEMUSERS")
public class SystemUsers implements Serializable {
    @Column(name = "C_USERNAME")
    String userName;
    @Column(name = "C_USERPHONENUMBER")
    String userPhoneNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonCreator
    public SystemUsers(@JsonProperty("id") long id,
                       @JsonProperty("userName")String userName,
                       @JsonProperty("userPhoneNumber")String userPhoneNumber) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.id = id;
    }

    public SystemUsers(String userName, String userPhoneNumber) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }

    public SystemUsers() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
