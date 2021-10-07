package com.li.feeling.feel;

import com.li.feeling.model.Feel;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;


/**
 * feel相关的服务
 */
public interface IFeelService {

    /**
     * 获得某个具体的feel的信息
     */
    @Nullable
    Feel getFeel(long feelId);

    // 首页获得feel列表数据
    @NonNull
    List<Feel> getHomeFeelList();

    // 获得用户自己发布的eel列表数据
    @NonNull
    List<Feel> getUserPublishedFeelList(@NonNull String userId);

    // 获得用户点赞的feel列表数据
    @NonNull
    List<Feel> getUserLikeFeelList(@NonNull String userId);

}
