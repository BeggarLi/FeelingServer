package com.li.feeling.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * description: feel
 */
public class Feel implements Serializable {

    @JsonProperty("id")
    public long mId;
    // 所属者
    @JsonProperty("user")
    public User mUser;
    // 发布时间
    @JsonProperty("publishTime")
    public long mPublishTime;
    // 内容文案
    @JsonProperty("contentText")
    public String mContentText;

    // 点赞数
    @JsonProperty("likeNum")
    public int mLikeNum;

    // 是否点赞过
    @JsonProperty("isLike")
    public boolean mIsLike;

    public Feel() {

    }
}
