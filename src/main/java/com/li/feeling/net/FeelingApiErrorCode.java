package com.li.feeling.net;

import javax.xml.transform.Source;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * description: 接口的所有的错误码都在这声明
 */
@Retention(RetentionPolicy.SOURCE)
public @interface FeelingApiErrorCode {

    int UN_KNOW = 0; // 未知错误
    int LOGIN_PHONE_ERROR = 1000; // 登陆时phone不存在
    int LOGIN_PASSWORD_ERROR = 1001; // 登陆时密码错误
    int PHONE_EMPTY = 1002;
    int PASSWORD_EMPTY = 1003;
    int REGISTER_PHONE_HAS_REGISTERED_ERROR = 1004;//注册时账号错误
    int FEEL_NOT_EXIST = 1005; // feel不存在
}
