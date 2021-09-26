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

    // 获得feel列表数据
    @NonNull
    default List<Feel> getFeelList() {
        return new ArrayList<>();
    }

    /**
     * 获得某个具体的feel的信息
     */
    @Nullable
    default Feel getFeel(long feelId) {
        return null;
    }

}
