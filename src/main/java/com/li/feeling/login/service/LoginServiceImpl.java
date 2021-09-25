package com.li.feeling.login.service;

import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

/**
 * description: 登陆服务实现类
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public User login(String account, String password) {
        return new User(account, password);
    }
}
