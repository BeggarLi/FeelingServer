package com.li.feeling.login;

import com.li.feeling.login.service.ILoginService;
import com.li.feeling.login.service.LoginResult;
import com.li.feeling.login.service.LoginServiceImpl;
import com.li.feeling.net.FeelingApiErrorCode;
import com.li.feeling.net.FeelingException;
import com.li.feeling.net.FeelingResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ILoginService mLoginService;

    // 登陆
    @RequestMapping("feeling/user/login")
    public FeelingResponse login(
            @RequestParam("phone") String phone,
            @RequestParam("password") String password) {
        System.out.println("receive login request");
        LoginResult result = mLoginService.login(phone, password);
        if (result.mResultCode == LoginResult.LoginResultCode.SUCCESS) {
            return FeelingResponse.success(result.mUser);
        }
        if (result.mResultCode == LoginResult.LoginResultCode.PHONE_ERROR) {
            return FeelingResponse.fail(FeelingApiErrorCode.LOGIN_PHONE_ERROR, "该手机号未注册");
        }
        if (result.mResultCode == LoginResult.LoginResultCode.PASSWORD_ERROR) {
            return FeelingResponse.fail(FeelingApiErrorCode.LOGIN_PASSWORD_ERROR, "密码错误");
        }
        return FeelingResponse.fail(FeelingApiErrorCode.UN_KNOW, "请稍后重试");
    }

}
