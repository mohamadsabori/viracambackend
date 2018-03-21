package com.viracam.backend.services.shippingmethod;

import com.viracam.backend.model.ShippingMethod;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by msabori on 1/31/18.
 */
public interface ShippingMethodRepository extends CrudRepository<ShippingMethod, Long> {
    ShippingMethod findByCode(String code);
}
