package com.li.feeling.feel.feellist.service;

/**
 * feel的点赞结果
 */
public class FeelLikeResult {

    // 该fell的点赞数
    public int mFeelLikeNum;

    @FeelLikeResultCode
    public int resultCode = FeelLikeResultCode.SUCCESS;

    public static FeelLikeResult success(int feelLikeNum) {
        FeelLikeResult result = new FeelLikeResult();
        result.mFeelLikeNum = feelLikeNum;
        return result;
    }

    public static FeelLikeResult fail(@FeelLikeResultCode int code) {
        FeelLikeResult result = new FeelLikeResult();
        result.resultCode = code;
        return result;
    }

    public @interface FeelLikeResultCode {
        int UN_KNOW = 0; // 未知错误
        int SUCCESS = 1; // 成功
        int UN_EXIT = 2; // 不存在
    }
}
