package com.viracam.backend.services.userorder;

import com.viracam.backend.model.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by msabori on 1/31/18.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "userorder", produces = "application/hal+json;charset=UTF-8")
public class UserOrderController {

    @Autowired
    UserOrderService service;

    @RequestMapping(value = "/adduserorder", method = RequestMethod.PUT)
    @ResponseBody
    public UserOrder addUserOrder(@RequestBody UserOrder order){
        System.out.println("User order saved with id\t0");
        UserOrder a = service.addUserOrder(order);
        System.out.println("User order saved with id\t" + a.getId());
        return a;
    }

    @RequestMapping(value = "/loaduserorders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<UserOrder> getUserOrders(@RequestBody @PathVariable("id") String userPhoneNumber) {
        return service.getUserOrders(userPhoneNumber);
    }

    @RequestMapping(value = "/loadallusersorders", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<UserOrder> getAllUsersOrders() {
        return service.getAllUsersOrders();
    }

    @RequestMapping(value = "/loadallusersordersbyid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserOrder loadAllUsersOrderById(@RequestBody @PathVariable("id") Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/confirmOrder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<UserOrder> confirmOrder(@RequestBody @PathVariable("id") long id) {
        return service.confirmOrder(id);
    }

    @RequestMapping(value = "/cancelOrder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<UserOrder> cancelOrder(@RequestBody @PathVariable("id") long id) {
        return service.cancelOrder(id);
    }

    @RequestMapping(value = "/userOrderPaid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<UserOrder> userOrderPaid(@RequestBody @PathVariable("id") long id) {
        return service.userOrderPaid(id);
    }
}
