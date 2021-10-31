package com.li.feeling.feel.like;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * description: 点赞接口的回执
 */
public class FeelLikeResponse implements Serializable {

    @JsonProperty("feelId")
    public long mFeelId;

    // 该feel的点赞数
    @JsonProperty("likeNum")
    public int mLikeNum;

    public FeelLikeResponse(long mFeelId, int likeNum) {
        this.mFeelId = mFeelId;
        mLikeNum = likeNum;
    }

}
