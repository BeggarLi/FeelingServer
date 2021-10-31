package com.li.feeling.model;

import org.springframework.lang.NonNull;

import java.util.*;

/**
 * description: Feel的点赞数据
 */
public class FeelLikeInfo {

    public long mFeelId; // feelId
    public long mUserId; // 点赞者的uid
    public long mTime; // 点赞时间
    public boolean mIsLike; // 点赞还是取消赞

}
