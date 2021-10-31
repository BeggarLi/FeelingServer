package com.li.feeling;

import com.li.feeling.model.Feel;
import com.li.feeling.model.FeelLikeData;
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

    // Feel的点赞数据
    public static FeelLikeData sFeelLikeData = new FeelLikeData();

}
