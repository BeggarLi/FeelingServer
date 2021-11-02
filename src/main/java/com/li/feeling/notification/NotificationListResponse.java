package com.li.feeling.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.li.feeling.model.notification.FeelingBaseNotification;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * description:
 */
public class NotificationListResponse {

    @JsonProperty("notificationList")
    @NonNull
    public List<FeelingBaseNotification> mNotificationList; // 列表数据

    @JsonProperty("footerTip")
    public String mFooterTip; // 底部提示(前段滑到底部时的提示)

    public NotificationListResponse(@NonNull List<FeelingBaseNotification> notificationList, String footerTip) {
        this.mNotificationList = notificationList;
        this.mFooterTip = footerTip;
    }

}
