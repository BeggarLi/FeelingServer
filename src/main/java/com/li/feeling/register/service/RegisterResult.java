package com.li.feeling.register.service;

import com.li.feeling.login.service.LoginResult;
import com.li.feeling.model.User;
import org.springframework.lang.NonNull;

/**
 * description: 注册结果
 */
public class RegisterResult {

    public User mUser; // 注册成功的话返回user信息

    @RegisterResultCode
    public int mResultCode = RegisterResultCode.SUCCESS;

    public static RegisterResult success(@NonNull User user) {
        RegisterResult registerResult = new RegisterResult();
        registerResult.mUser = user;
        return registerResult;
    }

    public static RegisterResult error(@RegisterResultCode int errorCode) {
        RegisterResult registerResult = new RegisterResult();
        registerResult.mResultCode = errorCode;
        return registerResult;
    }

    public @interface RegisterResultCode {
        int UN_KNOW = 0; // 未知错误
        int SUCCESS = 1; // 成功
        int PHONE_HAS_REGISTERED = 2; // phone已经被注册过
        int PHONE_EMPTY = 3; // 手机号为空
        int PASSWORD_EMPTY = 4; // 密码为空
    }

}
