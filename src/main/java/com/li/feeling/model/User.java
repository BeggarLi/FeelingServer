package com.li.feeling.model;

/**
 * description: 用户信息
 */
public class User {

    public String mAccount;
    public String mPassword;
    public String mNickName;

    public User(String mAccount, String mPassword) {
        this.mAccount = mAccount;
        this.mPassword = mPassword;
    }

    public User setNickName(String mNickName) {
        this.mNickName = mNickName;
        return this;
    }

}
