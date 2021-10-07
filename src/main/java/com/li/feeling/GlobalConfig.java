package com.li.feeling;

import com.li.feeling.model.Feel;
import com.li.feeling.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 测试用
 */
public class GlobalConfig {

    // 用户列表
    public static List<User> mUserList = new ArrayList<>();

    // feel列表
    public static List<Feel> mFeelList = new ArrayList<>();

    static {
        for (int i = 0; i < 6; i++) {
            Feel feel = new Feel();
            User user = new User(i + "phone", "pass");
            user.mNickName = i + "name";
            feel.mUser = user;
            feel.mLikeNum = i;
            feel.mContentText = i + "内容文案";
            feel.mPublishTime = System.currentTimeMillis();
            mFeelList.add(feel);
        }
    }

}
