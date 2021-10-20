package com.li.feeling.model;

import java.util.Map;
import java.util.Set;

/**
 * description: 用户和Feel的点赞数据
 */
public class FeelLikeData {

    // key--FeelId，value--给该feel点赞的所有userId
    public Map<Long, Set<Long>> mLikeMap;

}
