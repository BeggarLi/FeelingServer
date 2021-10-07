package com.li.feeling.feel.feellist.service;

import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeelServiceImpl implements IFeelService {

    @Override
    public Feel getFeel(long feelId) {
        return null;
    }

    @Override
    public List<Feel> getHomeFeelList() {
        List<Feel> feelList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Feel feel = new Feel();
            User user = new User(i + "phone", "pass");
            user.mNickName = i + "name";
            feel.mUser = user;
            feel.mLikeNum = i;
            feel.mContentText = i + "内容文案";
            feel.mPublishTime = System.currentTimeMillis();
            feelList.add(feel);
        }
        return feelList;
    }

    @Override
    public List<Feel> getUserPublishedFeelList(String userId) {
        List<Feel> feelList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Feel feel = new Feel();
            User user = new User(i + "phone", "pass");
            user.mNickName = i + "name";
            feel.mUser = user;
            feel.mLikeNum = i;
            feel.mContentText = i + "内容文案";
            feel.mPublishTime = System.currentTimeMillis();
            feelList.add(feel);
        }
        return feelList;
    }

    @Override
    public List<Feel> getUserLikeFeelList(String userId) {
        List<Feel> feelList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Feel feel = new Feel();
            User user = new User(i + "phone", "pass");
            user.mNickName = i + "name";
            feel.mUser = user;
            feel.mLikeNum = i;
            feel.mContentText = i + "内容文案";
            feel.mPublishTime = System.currentTimeMillis();
            feelList.add(feel);
        }
        return feelList;
    }

}
