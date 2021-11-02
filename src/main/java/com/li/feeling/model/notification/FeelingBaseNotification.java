package com.li.feeling.model.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * description: 通知的基类
 */
public class FeelingBaseNotification {

    // 类型
    @JsonProperty("type")
    private int mType;
    // 通知的时间
    @JsonProperty("time")
    private long mTime;

    public FeelingBaseNotification(@FeelingNotificationType int type, long time) {
        mType = type;
        mTime = time;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }
}
