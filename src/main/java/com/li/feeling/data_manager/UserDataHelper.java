package com.li.feeling.data_manager;

import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: User数据相关的工具类
 */
public class UserDataHelper {

    // 用户列表
    private static List<User> mUserList = new ArrayList<>();

    @NonNull
    public static List<User> getUserList() {
        List<User> users = new ArrayList<>();
        users.addAll(mUserList);
        return users;
    }

    // 添加
    public static void addUser(@NonNull User user) {
        mUserList.add(0, user);
    }

    // 获得User信息
    @Nullable
    public static User getUserByUid(long uid) {
        for (User user : mUserList) {
            if (user.mId == uid) {
                return user;
            }
        }
        return null;
    }

}
