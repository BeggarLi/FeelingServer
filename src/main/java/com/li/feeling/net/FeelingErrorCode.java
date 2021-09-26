package com.li.feeling.net;

import javax.xml.transform.Source;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * description: 所有的错误码都在这声明
 */
@Retention(RetentionPolicy.SOURCE)
public @interface FeelingErrorCode {

    int LOGIN_ACCOUNT_ERROR = 1000; // 登陆时账号不存在
    int LOGIN_PASSWORD_ERROR = 1001; // 登陆时密码错误
}
