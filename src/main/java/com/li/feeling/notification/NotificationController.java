package com.li.feeling.notification;

import com.li.feeling.feel.IFeelService;
import com.li.feeling.feel.feellist.FeelListResponse;
import com.li.feeling.model.Feel;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotification;
import com.li.feeling.net.FeelingResponse;
import com.li.feeling.notification.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description: 通知处理
 */
@RestController
public class NotificationController {

    @Autowired
    private INotificationService mNotificationService;

    @PostMapping("/feeling/feel/notification/list")
    public FeelingResponse<List<FeelingBaseNotification>> getNotificationList(@RequestParam("userId") long userId) {
        System.out.println("receive notification list request");
        List<FeelingBaseNotification> notifications = mNotificationService.getNotificationList(userId);
        NotificationListResponse response = new NotificationListResponse(notifications, "到底啦");
        return FeelingResponse.success(response);
    }

}
