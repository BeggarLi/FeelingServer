package com.li.feeling.publishfeel.service;

import com.li.feeling.data_manager.FeelDataHelper;
import com.li.feeling.data_manager.UserDataHelper;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements IPublishFeelService {
    @Override
    public Feel publish(long userId, String contentText) {
        Feel feel = null;
        for (User user : UserDataHelper.getUserList()) {
            if (user.mId == userId) {
                feel = new Feel();
                feel.mUser = user;
                feel.mId = generateNewFeelId();
                feel.mPublishTime = System.currentTimeMillis();
                feel.mContentText = contentText;
                feel.mLikeNum = 0;
                FeelDataHelper.addFeel(feel);
            }
        }
        return feel;
    }

    // 生成一个新的feelId : id是递增的
    private long generateNewFeelId() {
        long newId = 0;
        for (Feel feel : FeelDataHelper.getFeelList()) {
            newId = Math.max(newId, feel.mId);
        }
        return newId + 1;
    }

}
