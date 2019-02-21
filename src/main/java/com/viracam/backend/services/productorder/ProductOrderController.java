package com.viracam.backend.services.productorder;

import com.viracam.backend.model.ProductOrder;
import com.viracam.backend.model.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Mohammad on 1/17/2018.
 */
@CrossOrigin(origins = "*")
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

    @PostMapping(value = "/adduserorder")
    public @ResponseBody UserOrder addUserOrder(@RequestBody Map<String,String> map) {
        System.out.println("Start adding order");
//        UserOrder a = service.addUserOrder(userOrder);
//        UserOrder a = new UserOrder();
        System.out.println("End of adding order\t");
        return new UserOrder();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/adduserorder45")
    public @ResponseBody UserOrder addUserOrder45(@RequestBody UserOrder userOrder) {
        System.out.println("Start adding order");
        UserOrder a = service.addUserOrder(userOrder);
//        UserOrder a = new UserOrder();
        System.out.println("End of adding order\t" + a.getId());
        return a;
    }

    @RequestMapping(value = "/confirmProductOrder", method = RequestMethod.POST)
    @ResponseBody
    public ProductOrder confirmProductOrder(@RequestBody ProductOrder order) {
        return service.confirmProductOrder(order);
    }

    @RequestMapping(value = "/userOrderPaid", method = RequestMethod.GET)
    @ResponseBody
    public UserOrder userOrderPaid(@RequestParam(value = "id", required = true) long id,@RequestParam(value = "refID", required = true) String refID) {
        return service.userOrderPaid(id,refID);
    }

    @RequestMapping(value = "/loaduserproductorders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<ProductOrder> getUserProductOrders(@RequestBody @PathVariable("id") String userPhoneNumber) {
        return service.getUserOrders(userPhoneNumber);
    }

    @RequestMapping(value = "/loadalluserorders", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<ProductOrder> getAllUserOrders() {
        return service.getAllUserOrders();
    }
}
