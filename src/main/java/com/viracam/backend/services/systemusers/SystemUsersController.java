package com.viracam.backend.services.systemusers;

import com.viracam.backend.model.SystemUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by msabori on 1/27/18.
 */
@RestController
@RequestMapping(value = "users", produces = "application/hal+json;charset=UTF-8")
public class SystemUsersController {
    @Autowired
    SystemUsersService service;


    @RequestMapping(value = "/loadallusers", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<SystemUsers> getAllUsers(){
        return (ArrayList<SystemUsers>) service.findAll();
    }
}
