package com.li.feeling.data_manager;

import com.li.feeling.model.Feel;
import com.li.feeling.model.FeelLikeInfo;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 */
public class FeelDataHelper {

    // feel列表
    private static List<Feel> mFeelList = new ArrayList<>();

    // Feel的点赞数据
    private static List<FeelLikeInfo> mFeelLikeInfoList = new ArrayList<>();

    @NonNull
    public static List<Feel> getFeelList() {
        List<Feel> feelList = new ArrayList<>();
        feelList.addAll(mFeelList);
        return feelList;
    }

    // 添加
    public static void addFeel(@NonNull Feel feel) {
        mFeelList.add(0, feel);
    }

    @NonNull
    public static List<FeelLikeInfo> getFeelLikeInfos() {
        List<FeelLikeInfo> feelLikeInfos = new ArrayList<>();
        feelLikeInfos.addAll(mFeelLikeInfoList);
        return feelLikeInfos;
    }

    // 添加点赞信息
    public static void addFeelLikeInfo(@NonNull FeelLikeInfo feelLikeInfo) {
        mFeelLikeInfoList.add(0, feelLikeInfo);
    }

    // 获得Feel信息
    @Nullable
    public static Feel getFeelByFeelId(long feelId) {
        for (Feel feel : mFeelList) {
            if (feel.mId == feelId) {
                return feel;
            }
        }
        return null;
    }

}
