package com.li.feeling.login;

import com.li.feeling.login.service.LoginServiceImpl;
import com.li.feeling.model.User;
import com.li.feeling.net.FeelingErrorCode;
import com.li.feeling.net.FeelingException;
import com.li.feeling.net.FeelingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 处理登陆业务请求
 */
@RestController
public class LoginController {

    // 登陆服务
    @Autowired
    private LoginServiceImpl mLoginService;

    // 登陆
        @RequestMapping("feeling/user/login")
    public FeelingResponse<User> login(
            @RequestParam("phone") String phone,
            @RequestParam("password") String password) {
        System.out.println("receive login request");
//        if (1==1) {
//            throw new FeelingException(FeelingErrorCode.LOGIN_PASSWORD_ERROR, "密码错误");
//        }
        User user = mLoginService.login(phone, password);
        return FeelingResponse.success(user);
    }

}
