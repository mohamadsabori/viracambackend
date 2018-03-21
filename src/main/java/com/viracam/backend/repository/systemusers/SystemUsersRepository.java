package com.viracam.backend.repository.systemusers;

import com.viracam.backend.model.ProductOrder;
import com.viracam.backend.model.SystemUsers;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mohammad on 1/17/2018.
 */
public interface SystemUsersRepository extends CrudRepository<SystemUsers,Long> {
    public SystemUsers findByUserPhoneNumber(String userPhoneNumber);
}
