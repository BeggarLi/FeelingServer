package com.li.feeling.register.service;

import com.li.feeling.GlobalConfig;
import com.li.feeling.login.service.LoginResult;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import com.li.feeling.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements IRegisterService {

    @Override
    public RegisterResult register(String phone, String password) {
        if (StringUtil.isEmpty(phone)) {
            return RegisterResult.error(RegisterResult.RegisterResultCode.PHONE_EMPTY);
        }
        if (StringUtil.isEmpty(password)) {
            return RegisterResult.error(RegisterResult.RegisterResultCode.PASSWORD_EMPTY);
        }
        for (User user : GlobalConfig.mUserList) {
            // phone相等
            if (user.mPhone.equals(phone)) {
                return RegisterResult.error(RegisterResult.RegisterResultCode.PHONE_HAS_REGISTERED);
            }
        }
        User user = new User(phone, password);
        user.mId = generateNewUserId();
        user.mNickName = user.mId + "";
        GlobalConfig.mUserList.add(user);
        return RegisterResult.success(user);
    }

    // 生成一个新的UserId : id是递增的
    private long generateNewUserId() {
        long newId = 1000;
        for (User user : GlobalConfig.mUserList) {
            newId = Math.max(newId, user.mId);
        }
        return newId + 1;
    }
}
