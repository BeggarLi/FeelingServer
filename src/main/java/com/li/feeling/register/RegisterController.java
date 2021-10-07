package com.li.feeling.register;

import com.li.feeling.model.User;
import com.li.feeling.net.FeelingApiErrorCode;
import com.li.feeling.net.FeelingResponse;
import com.li.feeling.register.service.IRegisterService;
import com.li.feeling.register.service.RegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private IRegisterService mRegisterService;

    @PostMapping("/feeling/user/register")
    public FeelingResponse<User> register(
            @RequestParam("phone") String phone, @RequestParam("password") String password) {
        System.out.println("receive register request");

        RegisterResult result = mRegisterService.register(phone, password);
        if (result.mResultCode == RegisterResult.RegisterResultCode.SUCCESS) {
            return FeelingResponse.success(result.mUser);
        }
        if (result.mResultCode == RegisterResult.RegisterResultCode.PHONE_HAS_REGISTERED) {
            return FeelingResponse.fail(FeelingApiErrorCode.REGISTER_PHONE_HAS_REGISTERED_ERROR, "该手机号已经被注册");
        }
        if (result.mResultCode == RegisterResult.RegisterResultCode.PHONE_HAS_REGISTERED) {
            return FeelingResponse.fail(FeelingApiErrorCode.PHONE_EMPTY, "手机号不能为空");
        }
        if (result.mResultCode == RegisterResult.RegisterResultCode.PHONE_HAS_REGISTERED) {
            return FeelingResponse.fail(FeelingApiErrorCode.PASSWORD_EMPTY, "密码不能为空");
        }
        return FeelingResponse.fail(FeelingApiErrorCode.UN_KNOW, "请稍后再试");
    }

}
