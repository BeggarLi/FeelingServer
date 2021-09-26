package com.li.feeling.feel.feellist.service;

import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeelListServiceImpl implements IFeelService {

    @Override
    public List<Feel> getFeelList() {
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
