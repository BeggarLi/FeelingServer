package com.li.feeling.register.service;

import com.li.feeling.model.User;

public interface IRegisterService {

    User register(String account,String password);
}
