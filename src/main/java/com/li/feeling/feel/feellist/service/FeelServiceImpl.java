package com.li.feeling.feel.feellist.service;

import com.li.feeling.GlobalConfig;
import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
import com.li.feeling.model.User;
import com.li.feeling.net.FeelingApiErrorCode;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List likeList = new ArrayList<Feel>();
        for (Feel feel : GlobalConfig.mFeelList) {
            long feelId = feel.mId;
            if (GlobalConfig.sFeelLikeData.mLikeMap.containsKey(feelId)
                    && GlobalConfig.sFeelLikeData.mLikeMap.get(feelId).contains(userId)) {
                likeList.add(feel);
            }
        }
        return likeList;
    }


    // TODO: 2021/10/21 返回结果
    @Override
    public int like(long userId, long feelId) {
        for (Feel feel : GlobalConfig.mFeelList) {
            // 判断Feel有没有
            if (feel.mId == feelId) {
                if (!GlobalConfig.sFeelLikeData.mLikeMap.containsKey(feelId)) {
                    GlobalConfig.sFeelLikeData.mLikeMap.put(feelId, new HashSet<>());
                }
                Set<Long> mLikeUsers = GlobalConfig.sFeelLikeData.mLikeMap.get(feelId);
                mLikeUsers.add(userId);
                feel.mLikeNum = mLikeUsers.size();
                return 1;
            }
        }
        return FeelingApiErrorCode.FEEL_NOT_EXIST;
    }

    @Override
    public int cancelLike(long userId, long feelId) {
        for (Feel feel : GlobalConfig.mFeelList) {
            // 判断Feel有没有
            if (feel.mId == feelId) {
                if (GlobalConfig.sFeelLikeData.mLikeMap.containsKey(feelId)) {
                    Set<Long> mLikeUsers = GlobalConfig.sFeelLikeData.mLikeMap.get(feelId);
                    mLikeUsers.remove(userId);
                    feel.mLikeNum = mLikeUsers.size();
                }
                return 1;
            }
        }
        return FeelingApiErrorCode.FEEL_NOT_EXIST;
    }

}
