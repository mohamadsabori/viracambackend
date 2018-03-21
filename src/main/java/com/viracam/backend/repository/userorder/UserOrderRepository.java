package com.viracam.backend.repository.userorder;

import com.viracam.backend.model.UserOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by msabori on 1/31/18.
 */
public interface UserOrderRepository extends CrudRepository<UserOrder,Long> {
}
