package com.li.feeling.register;

import com.li.feeling.login.service.LoginServiceImpl;
import com.li.feeling.model.User;
import com.li.feeling.net.FeelingErrorCode;
import com.li.feeling.net.FeelingException;
import com.li.feeling.net.FeelingResponse;
import com.li.feeling.register.service.IRegisterService;
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
            @RequestParam String account
            ,@RequestParam String password
    ){
        System.out.println("receive register request");
        if (true){
            throw new FeelingException(FeelingErrorCode.REGISTER_ACCOUNT_ERROR,"注册手机号有误");
        }
        User user = mRegisterService.register(account,password);
        return FeelingResponse.success(user);
    }

}
