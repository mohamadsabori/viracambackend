package com.viracam.backend.services.userorder;

import com.viracam.backend.model.UserOrder;
import com.viracam.backend.repository.userorder.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by msabori on 1/31/18.
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    UserOrderRepository repository;

    @Override
    public UserOrder addUserOrder(UserOrder order) {
        return repository.save(order);
    }

    @Override
    public Iterable<UserOrder> getUserOrders(String userPhoneNumber) {
        return repository.findByUserPhoneNumber(userPhoneNumber);
    }
}
