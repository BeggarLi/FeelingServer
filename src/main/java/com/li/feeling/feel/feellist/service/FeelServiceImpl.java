package com.li.feeling.feel.feellist.service;

import com.li.feeling.GlobalConfig;
import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
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
    public List<Feel> getHomeFeelList(long userId) {
        List<Feel> feelList = new ArrayList<>();
        for (Feel feel : GlobalConfig.mFeelList) {
            if (isLike(userId, feel.mId)) {
                feel.mIsLike = true;
            }else {
                feel.mIsLike = false;
            }
            feelList.add(feel);
        }
        return feelList;
    }

    @Override
    public List<Feel> getUserPublishedFeelList(long userId) {
        List userPublishedFeelList = new ArrayList<Feel>();
        for (Feel feel : GlobalConfig.mFeelList) {
            if (feel.mUser.mId == userId) {
                userPublishedFeelList.add(feel);
                long feelId = feel.mId;
                // 自己也可以给自己点赞
                if (isLike(userId, feel.mId)) {
                    feel.mIsLike = true;
                }else {
                    feel.mIsLike = false;
                }
            }
        }
        return userPublishedFeelList;
    }

    @Override
    public List<Feel> getUserLikeFeelList(long userId) {
        List likeList = new ArrayList<Feel>();
        for (Feel feel : GlobalConfig.mFeelList) {
            if (isLike(userId, feel.mId)) {
                likeList.add(feel);
            }
        }
        return likeList;
    }


    // TODO: 2021/10/21 返回结果
    @Override
    public FeelLikeResult like(long userId, long feelId) {
        for (Feel feel : GlobalConfig.mFeelList) {
            // 判断Feel有没有
            if (feel.mId == feelId) {
                if (!GlobalConfig.sFeelLikeData.mLikeMap.containsKey(feelId)) {
                    GlobalConfig.sFeelLikeData.mLikeMap.put(feelId, new HashSet<>());
                }
                Set<Long> mLikeUsers = GlobalConfig.sFeelLikeData.mLikeMap.get(feelId);
                mLikeUsers.add(userId);
                feel.mLikeNum = mLikeUsers.size();
                return FeelLikeResult.success(feel.mLikeNum);
            }
        }
        return FeelLikeResult.fail(FeelingApiErrorCode.FEEL_NOT_EXIST);
    }

    @Override
    public FeelLikeResult cancelLike(long userId, long feelId) {
        for (Feel feel : GlobalConfig.mFeelList) {
            // 判断Feel有没有
            if (feel.mId == feelId) {
                if (GlobalConfig.sFeelLikeData.mLikeMap.containsKey(feelId)) {
                    Set<Long> mLikeUsers = GlobalConfig.sFeelLikeData.mLikeMap.get(feelId);
                    mLikeUsers.remove(userId);
                    feel.mLikeNum = mLikeUsers.size();
                }
                return FeelLikeResult.success(feel.mLikeNum);
            }
        }
        return FeelLikeResult.fail(FeelingApiErrorCode.FEEL_NOT_EXIST);
    }

    // user是否点赞过该feel
    private boolean isLike(long userId, long feelId) {
        return GlobalConfig.sFeelLikeData.mLikeMap.containsKey(feelId)
                && GlobalConfig.sFeelLikeData.mLikeMap.get(feelId).contains(userId);
    }

}
