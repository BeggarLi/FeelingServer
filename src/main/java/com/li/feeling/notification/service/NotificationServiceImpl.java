package com.li.feeling.notification.service;

import com.li.feeling.data_manager.FeelDataHelper;
import com.li.feeling.data_manager.UserDataHelper;
import com.li.feeling.model.Feel;
import com.li.feeling.model.FeelLikeInfo;
import com.li.feeling.model.notification.FeelLikeNotification;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.FeelingNotification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Override
    public List<FeelingBaseNotification> getNotificationList(long userId) {
        List<FeelingBaseNotification> notifications = new ArrayList<>();
        // 点赞通知
        // 同一个用户对同一个feel可能点赞取消赞多次，需要只取最后一次操作的
        Set<Long> hasRecordFeelIdSet = new HashSet<>();
        for (FeelLikeInfo feelLikeInfo : FeelDataHelper.getFeelLikeInfos()) {
            long feelId = feelLikeInfo.mFeelId;
            if (isFeelBelongTo(feelId, userId) && !hasRecordFeelIdSet.contains(feelId)) {
                hasRecordFeelIdSet.add(feelId);

                FeelLikeNotification likeNotification = new FeelLikeNotification(feelLikeInfo.mTime);
                likeNotification.setFeel(FeelDataHelper.getFeelByFeelId(feelId));
                likeNotification.setUser(UserDataHelper.getUserByUid(feelLikeInfo.mUserId));

                notifications.add(likeNotification);
            }
        }

        // 关注通知

        // 聊天通知

        return notifications;
    }

    // 某feel是不是uid这个用户的
    private boolean isFeelBelongTo(long feelId, long uid) {
        for (Feel feel : FeelDataHelper.getFeelList()) {
            if (feel.mUser.mId == uid) {
                return true;
            }
        }
        return false;
    }

}
