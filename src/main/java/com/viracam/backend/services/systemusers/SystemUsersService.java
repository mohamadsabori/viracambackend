package com.viracam.backend.services.systemusers;

import com.viracam.backend.model.SystemUsers;

/**
 * Created by Mohammad on 1/15/2018.
 */
public interface SystemUsersService {
    public Iterable<SystemUsers> findAll();
    public SystemUsers addUser(SystemUsers user);

    SystemUsers findByUserPhoneNumber(String phoneNum);
}
