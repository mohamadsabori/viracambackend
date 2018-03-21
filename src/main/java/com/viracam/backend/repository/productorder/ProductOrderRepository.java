package com.viracam.backend.repository.productorder;

import com.viracam.backend.model.Product;
import com.viracam.backend.model.ProductOrder;
import com.viracam.backend.model.SystemUsers;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by Mohammad on 1/8/2018.
 */
public interface ProductOrderRepository extends CrudRepository<ProductOrder,Long> {
    ArrayList<ProductOrder> getByUser(SystemUsers user);
}
