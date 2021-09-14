package com.li.feeling.login.service;

import com.li.feeling.model.User;

/**
 * description:
 */
public interface ILoginService {

    // 登陆
    User login(String account, String password);

}
