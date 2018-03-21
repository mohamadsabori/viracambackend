package com.viracam.backend.services.productorder;

import com.viracam.backend.model.ProductOrder;
import com.viracam.backend.model.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Mohammad on 1/17/2018.
 */
@RestController
@RequestMapping(value = "productorder", produces = "application/hal+json;charset=UTF-8")
public class ProductOrderController {
    @Autowired
    ProductOrdersService service;

    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    @ResponseBody
    public ProductOrder registerNewOrder(@RequestBody AddOrderDTO addOrderDTO) {
        return service.registerNewOrder(addOrderDTO.getProductId(), addOrderDTO.getUserPhoneNumber());
//        return service.registerNewOrder(productId, "09124850689");
    }

    @RequestMapping(value = "/adduserorder", method = RequestMethod.POST)
    @ResponseBody
    public UserOrder addUserOrder(@RequestBody UserOrder userOrder) {
        return service.addUserOrder(userOrder);
    }

    @RequestMapping(value = "/confirmProductOrder", method = RequestMethod.POST)
    @ResponseBody
    public ProductOrder confirmProductOrder(@RequestBody ProductOrder order) {
        return service.confirmProductOrder(order);
    }

    @RequestMapping(value = "/loaduserorders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<ProductOrder> getUserOrders(@RequestBody @PathVariable("id") String userPhoneNumber) {
        return service.getUserOrders(userPhoneNumber);
    }

    @RequestMapping(value = "/loadalluserorders", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<ProductOrder> getAllUserOrders() {
        return service.getAllUserOrders();
    }
}
