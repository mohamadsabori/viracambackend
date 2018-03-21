package com.viracam.backend.services.productorder;

import com.viracam.backend.model.ProductOrder;
import com.viracam.backend.model.UserOrder;

import java.util.ArrayList;

/**
 * Created by Mohammad on 1/17/2018.
 */
public interface ProductOrdersService {
    ProductOrder registerNewOrder(long productId, String userPhoneNumber);

    ArrayList<ProductOrder> getUserOrders(String userPhoneNumber);

    Iterable<ProductOrder> getAllUserOrders();

    ProductOrder confirmProductOrder(ProductOrder order);

    UserOrder addUserOrder(UserOrder userOrder);
}
