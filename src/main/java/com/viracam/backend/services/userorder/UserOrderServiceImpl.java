package com.viracam.backend.services.userorder;

import com.viracam.backend.model.Category;
import com.viracam.backend.model.UserOrder;
import com.viracam.backend.repository.userorder.UserOrderRepository;
import com.viracam.backend.services.category.CategoryService;
import com.viracam.backend.util.CategoryCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by msabori on 1/31/18.
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Autowired
    UserOrderRepository repository;
    @Autowired
    CategoryService categoryService;

    @Override
    public UserOrder addUserOrder(UserOrder order) {
        return repository.save(order);
    }

    @Override
    public Iterable<UserOrder> getUserOrders(String userPhoneNumber) {
        return repository.findByUserPhoneNumber(userPhoneNumber);
    }

    @Override
    public Iterable<UserOrder> getAllUsersOrders() {
        return repository.findAll();
    }

    @Override
    public UserOrder findById(long id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<UserOrder> confirmOrder(long id) {
        UserOrder order = findById(id);
        Category category = categoryService.findByCode(CategoryCodes.CONFIRM_ORDER);
        order.setOrderStatus(category);
        repository.save(order);
        return getAllUsersOrders();
    }

    @Override
    public Iterable<UserOrder> cancelOrder(long id) {
        UserOrder order = findById(id);
        Category category = categoryService.findByCode(CategoryCodes.CANCEL_ORDER);
        order.setOrderStatus(category);
        repository.save(order);
        return getAllUsersOrders();
    }

    @Override
    public Iterable<UserOrder> userOrderPaid(long id) {
        UserOrder order = findById(id);
        Category category = categoryService.findByCode(CategoryCodes.ORDER_PAIED);
        order.setOrderStatus(category);
        repository.save(order);
        return getAllUsersOrders();
    }
}
