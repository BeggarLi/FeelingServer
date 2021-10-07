package com.li.feeling.login.service;

import com.li.feeling.GlobalConfig;
import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

/**
 * description: 登陆服务实现类
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public LoginResult login(String phone, String password) {
        LoginResult loginResult = new LoginResult();
        for (User user : GlobalConfig.mUserList) {
            // phone相等
            if (user.mPhone.equals(phone)) {
                if (user.mPassword.equals(password)) {
                    loginResult.mUser = user;
                    return loginResult;
                } else {
                    loginResult.mResultCode = LoginResult.LoginResultCode.PASSWORD_ERROR;
                    return loginResult;
                }
            }
        }
        loginResult.mResultCode = LoginResult.LoginResultCode.PHONE_ERROR;
        return loginResult;
    }

}
