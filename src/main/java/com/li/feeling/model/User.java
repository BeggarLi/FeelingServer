package com.li.feeling.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * description: 用户信息
 */
public class User implements Serializable {

    @JsonProperty("id")
    public String mId;
    @JsonProperty("phone")
    public String mPhone; // 手机号
    @JsonProperty("password")
    public String mPassword; // 密码
    @JsonProperty("nickname")
    public String mNickName; // 昵称
    @JsonProperty("sex")
    public String mSex; // 性别,M代表男，F代表女

    public User(String phone, String mPassword) {
        this.mPhone = phone;
        this.mPassword = mPassword;
    }

}
