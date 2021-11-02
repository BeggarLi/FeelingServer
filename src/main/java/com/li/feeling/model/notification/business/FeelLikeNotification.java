package com.li.feeling.model.notification.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotificationType;

/**
 * description: feel点赞的通知
 */
public class FeelLikeNotification extends FeelingBaseNotification {

    // feel
    @JsonProperty("feel")
    private Feel mFeel;
    // 点赞的人
    @JsonProperty("user")
    private User mUser;
    // 显示的文案
    @JsonProperty("tip")
    private String mTip;

    public FeelLikeNotification(long time) {
        super(FeelingNotificationType.FEEL_LIKE, time);
    }

    public Feel getFeel() {
        return mFeel;
    }

    public void setFeel(Feel feel) {
        mFeel = feel;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public String getTip() {
        return mTip;
    }

    public void setTip(String tip) {
        this.mTip = tip;
    }
}
