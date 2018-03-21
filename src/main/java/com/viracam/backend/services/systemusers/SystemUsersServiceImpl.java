package com.viracam.backend.services.systemusers;

import com.viracam.backend.model.SystemUsers;
import com.viracam.backend.repository.systemusers.SystemUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mohammad on 1/17/2018.
 */
@Service
public class SystemUsersServiceImpl implements SystemUsersService{
    @Autowired
    SystemUsersRepository repository;

    @Override
    public Iterable<SystemUsers> findAll() {
        return repository.findAll();
    }

    @Override
    public SystemUsers addUser(SystemUsers user) {
        return repository.save(user);
    }

    @Override
    public SystemUsers findByUserPhoneNumber(String phoneNum) {
        return repository.findByUserPhoneNumber(phoneNum);
    }
}
