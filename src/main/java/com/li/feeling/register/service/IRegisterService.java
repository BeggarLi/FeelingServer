package com.li.feeling.register.service;

import com.li.feeling.model.User;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

// 注册服务
public interface IRegisterService {

    RegisterResult register(@Nullable String phone, @Nullable String password);
}
