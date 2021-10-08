package com.li.feeling.publishfeel.service;

import com.li.feeling.GlobalConfig;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import org.springframework.stereotype.Service;
import sun.security.action.GetLongAction;

@Service
public class PublishServiceImpl implements IPublishFeelService {
    @Override
    public Feel publish(long userId, String contentText) {
        Feel feel = new Feel();
        for (User user : GlobalConfig.mUserList) {
            if (user.mId == userId) {
                feel.mUser = user;
            }
        }
        feel.mId = generateNewFeelId();
        feel.mPublishTime = System.currentTimeMillis();
        feel.mContentText = contentText;
        feel.mLikeNum = 0;

        GlobalConfig.mFeelList.add(0, feel);
        return new Feel();
    }

    // 生成一个新的feelId : id是递增的
    private long generateNewFeelId() {
        long newId = 0;
        for (Feel feel : GlobalConfig.mFeelList) {
            newId = Math.max(newId, feel.mId);
        }
        return newId + 1;
    }

}
