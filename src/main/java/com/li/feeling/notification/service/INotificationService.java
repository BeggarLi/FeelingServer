package com.li.feeling.notification.service;

import com.li.feeling.model.notification.FeelingBaseNotification;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * description: 通知服务
 */
public interface INotificationService {

    // 获得某用户的通知
    List<FeelingBaseNotification> getNotificationList(@NonNull long userId);

}
