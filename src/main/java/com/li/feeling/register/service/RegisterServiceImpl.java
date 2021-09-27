package com.li.feeling.register.service;

import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements IRegisterService{

    @Override
    public User register(String account, String password) {
        return new User(account,password);
    }
}
