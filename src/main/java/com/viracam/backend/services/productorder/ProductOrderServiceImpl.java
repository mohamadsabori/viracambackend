package com.viracam.backend.services.productorder;

import com.github.mfathi91.time.PersianDate;
import com.viracam.backend.model.*;
import com.viracam.backend.repository.category.CategoryRepository;
import com.viracam.backend.repository.product.ProductRepository;
import com.viracam.backend.repository.productimages.ProductImagesRepository;
import com.viracam.backend.repository.productorder.ProductOrderRepository;
import com.viracam.backend.repository.systemusers.SystemUsersRepository;
import com.viracam.backend.repository.userorder.UserOrderRepository;
import com.viracam.backend.util.CategoryCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mohammad on 1/17/2018.
 */
@Service
public class ProductOrderServiceImpl implements ProductOrdersService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductOrderRepository productOrderRepository;
    @Autowired
    SystemUsersRepository systemUsersRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserOrderRepository orderRepository;
    @Autowired
    ProductImagesRepository imagesRepository;

    @Override
    public ProductOrder registerNewOrder(long productId, String userPhoneNumber) {
        SystemUsers user = systemUsersRepository.findByUserPhoneNumber(userPhoneNumber);
        Product product = productRepository.findOne(productId);
        ProductOrder order = new ProductOrder(product, user, "", "", categoryRepository.findByCode("START_ORDER"), new UserOrder(), 0,BigDecimal.ZERO);
        return productOrderRepository.save(order);
    }

    @Override
    public ArrayList<ProductOrder> getUserOrders(String userPhoneNumber) {
        SystemUsers user = systemUsersRepository.findByUserPhoneNumber(userPhoneNumber);
        ArrayList<ProductOrder> productOrders = productOrderRepository.getByUser(user);
        return productOrders;
    }

    @Override
    public Iterable<ProductOrder> getAllUserOrders() {
        return productOrderRepository.findAll();
    }

    @Override
    public ProductOrder confirmProductOrder(ProductOrder order) {
        ProductOrder newOrdr = productOrderRepository.findOne(order.getId());
        newOrdr.setOrderStatus(categoryRepository.findByCode(CategoryCodes.CONFIRM_ORDER));
        return productOrderRepository.save(newOrdr);
    }

    @Override
    public UserOrder addUserOrder(UserOrder userOrder) {
        userOrder.setOrderStatus(categoryRepository.findByCode(CategoryCodes.START_ORDER));
        userOrder.setOrderDate(PersianDate.now().toString());
        userOrder.setOrderTime(String.valueOf(new Date().getTime()));
        userOrder.setOrderSerial(getUserNewOrderSerial(userOrder.getUserPhoneNumber()));
        BigDecimal totalFactor = BigDecimal.ZERO;
        for (ProductOrder order : userOrder.getOrderset()) {
            order.setOrderStatus(categoryRepository.findByCode(CategoryCodes.START_ORDER));
            order.setOrderDate(PersianDate.now().toString());
            order.setOrderTime(String.valueOf(new Date().getTime()));
            SystemUsers user = systemUsersRepository.findByUserPhoneNumber(userOrder.getUserPhoneNumber());
            if(user == null){
                user = new SystemUsers(userOrder.getUserFullName(),userOrder.getUserPhoneNumber());
                user = systemUsersRepository.save(user);
            }
            order.setUser(user);
            totalFactor = totalFactor.add(order.getTotalPrice());
            productOrderRepository.save(order);
        }
        userOrder.setTotalFactor(totalFactor);
        return orderRepository.save(userOrder);
    }

    private String getUserNewOrderSerial(String userPhoneNumber) {
        ArrayList<UserOrder> userOrders = (ArrayList<UserOrder>) orderRepository.findByUserPhoneNumber(userPhoneNumber);
        return String.valueOf(userOrders.size() + 1);
    }
}
