package com.li.feeling.notification.service;

import com.li.feeling.data_manager.FeelDataHelper;
import com.li.feeling.data_manager.UserDataHelper;
import com.li.feeling.model.Feel;
import com.li.feeling.model.FeelLikeInfo;
import com.li.feeling.model.notification.FeelingBaseNotification;
import com.li.feeling.model.notification.business.FeelLikeNotification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Override
    public List<FeelingBaseNotification> getNotificationList(long userId) {
        List<FeelingBaseNotification> notifications = new ArrayList<>();
        // 点赞通知
        // key--feelId,value--操作者集合
        Map<Long, Set<Long>> hasRecordSet = new HashMap();
        for (FeelLikeInfo feelLikeInfo : FeelDataHelper.getFeelLikeInfos()) {
            long feelId = feelLikeInfo.mFeelId;
            Feel feel = FeelDataHelper.getFeelByFeelId(feelId);
            // 不是自己的feel不关心
            if (feel == null || feel.mUser.mId != userId) {
                continue;
            }
            long uid = feelLikeInfo.mUserId; // 操作者的id
            // 自己对自己的feel点赞操作过滤
            if (uid == userId) {
                continue;
            }

            // 确保noNUll
            if (!hasRecordSet.containsKey(feelId)) {
                hasRecordSet.put(feelId, new HashSet<>());
            }
            // 同一个用户对同一个feel可能点赞取消赞多次，只取一次
            if (!hasRecordSet.get(feelId).contains(uid)) {
                hasRecordSet.get(feelId).add(uid);
                // 取消点赞不记录到通知列表中
                if (!feelLikeInfo.mIsLike) {
                    continue;
                }
                FeelLikeNotification likeNotification = new FeelLikeNotification(feelLikeInfo.mTime);
                likeNotification.setFeel(FeelDataHelper.getFeelByFeelId(feelId));
                likeNotification.setUser(UserDataHelper.getUserByUid(feelLikeInfo.mUserId));
                likeNotification.setTip("点赞了你的feel");

                notifications.add(likeNotification);
            }
        }

        // 关注通知

        // 聊天通知

        return notifications;
    }

}
