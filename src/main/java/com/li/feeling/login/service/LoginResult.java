package com.li.feeling.login.service;

import com.li.feeling.model.User;

/**
 * description: 登录结果
 */
public class LoginResult {

    public User mUser; // 登录成功的话返回user信息

    @LoginResultCode
    public int mResultCode = LoginResultCode.SUCCESS;

    public @interface LoginResultCode {
        int UN_KNOW = 0; // 未知错误
        int SUCCESS = 1; // 成功
        int PHONE_ERROR = 2; // phone错误
        int PASSWORD_ERROR = 3; // 密码错误
    }

}
