package com.viracam.backend.services.userorder;

import com.viracam.backend.model.UserOrder;

/**
 * Created by msabori on 1/31/18.
 */
public interface UserOrderService {
    UserOrder addUserOrder(UserOrder order);

    Iterable<UserOrder> getUserOrders(String userPhoneNumber);

    Iterable<UserOrder> getAllUsersOrders();

    UserOrder findById(long id);

    Iterable<UserOrder> confirmOrder(long id);

    Iterable<UserOrder>
    cancelOrder(long id);

    Iterable<UserOrder> userOrderPaid(long id);
}
