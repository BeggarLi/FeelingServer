package com.li.feeling.feel.feellist.service;

/**
 * feel的点赞结果
 */
public class FeelLikeResult {

    @FeelLikeResultCode
    public int resultCode =FeelLikeResultCode.SUCCESS;

    public @interface FeelLikeResultCode{
        int UN_KNOW = 0; // 未知错误
        int SUCCESS = 1; // 成功
        int UN_EXIT = 2; // 不存在
    }
}
