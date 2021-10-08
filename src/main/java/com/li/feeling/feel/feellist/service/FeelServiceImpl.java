package com.li.feeling.feel.feellist.service;

import com.li.feeling.GlobalConfig;
import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FeelServiceImpl implements IFeelService {

    @Override
    public Feel getFeel(long feelId) {
        for (Feel feel : GlobalConfig.mFeelList) {
            if (feel.mId == feelId) {
                return feel;
            }
        }
        return null;
    }

    @Override
    public List<Feel> getHomeFeelList() {
        return GlobalConfig.mFeelList;
    }

    @Override
    public List<Feel> getUserPublishedFeelList(long userId) {
        List userPublishedFeelList = new ArrayList<Feel>();
        for (Feel feel : GlobalConfig.mFeelList) {
            if (feel.mUser.mId == userId) {
                userPublishedFeelList.add(feel);
            }
        }
        return userPublishedFeelList;
    }

    @Override
    public List<Feel> getUserLikeFeelList(long userId) {
        return new ArrayList<>();
    }

}
