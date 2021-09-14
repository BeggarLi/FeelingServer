package com.li.feeling.login;

import com.li.feeling.login.service.LoginServiceImpl;
import com.li.feeling.model.User;
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
    @RequestMapping("/user/login")
    public User login(
            @RequestParam("account") String account,
            @RequestParam("password") String password) {
        System.out.println("receive login request");
        return mLoginService.login(account, password);
    }

}
