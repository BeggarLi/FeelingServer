package com.li.feeling.feel;

import com.li.feeling.feel.feellist.FeelListResponse;
import com.li.feeling.feel.feellist.service.FeelLikeResult;
import com.li.feeling.feel.like.FeelLikeResponse;
import com.li.feeling.model.Feel;
import com.li.feeling.net.FeelingApiErrorCode;
import com.li.feeling.net.FeelingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * feel相关的接口
 */
@RestController
public class FeelController {

    @Autowired
    private IFeelService mFeelService;

    @PostMapping("/feeling/feel/home/list")
    public FeelingResponse<Feel> getHomeFeelListData(@RequestParam("userId") long userId) {
        System.out.println("receive home feelList request");
        List<Feel> feelList = mFeelService.getHomeFeelList(userId);
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }

    // 获取用户自己发布的feel列表数据
    @PostMapping("/feeling/feel/user/published/list")
    public FeelingResponse<Feel> getUserPublishedFeelListData(@RequestParam("userId") long userId) {
        System.out.println("receive published feelList request");
        List<Feel> feelList = mFeelService.getUserPublishedFeelList(userId);
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }

    // 获取用户点赞的feel列表数据
    @PostMapping("/feeling/feel/user/like/list")
    public FeelingResponse<Feel> getUserLikeFeelListData(@RequestParam("userId") long userId) {
        System.out.println("receive likes feelList request");
        List<Feel> feelList = mFeelService.getUserLikeFeelList(userId);
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }

    // 点赞
    @PostMapping("/feeling/feel/like")
    public FeelingResponse<Feel> likeFeel(
            @RequestParam("userId") long userId,
            @RequestParam("feelId") long feelId) {
        System.out.println("receive feel like request");
        FeelLikeResult result = mFeelService.like(userId, feelId);

        //点赞成功
        if (result.resultCode == FeelLikeResult.FeelLikeResultCode.SUCCESS) {
            return FeelingResponse.success(new FeelLikeResponse(feelId, result.mFeelLikeNum));
        }
        //此feel不存在
        if (result.resultCode == FeelLikeResult.FeelLikeResultCode.UN_EXIT) {
            return FeelingResponse.fail(FeelingApiErrorCode.FEEL_NOT_EXIST, "该条feel不存在");
        }
        //未知错误
        return FeelingResponse.fail(FeelingApiErrorCode.UN_KNOW, "未知错误");

    }

    // 取消点赞
    @PostMapping("/feeling/feel/cancellike")
    public FeelingResponse<Feel> cancelLikeFeel(
            @RequestParam("userId") long userId,
            @RequestParam("feelId") long feelId) {
        System.out.println("receive feel cancel like request");
        FeelLikeResult result = mFeelService.cancelLike(userId, feelId);

        //取消点赞成功
        if (result.resultCode == FeelLikeResult.FeelLikeResultCode.SUCCESS) {
            return FeelingResponse.success(new FeelLikeResponse(feelId, result.mFeelLikeNum));
        }
        //此feel不存在
        if (result.resultCode == FeelLikeResult.FeelLikeResultCode.UN_EXIT) {
            return FeelingResponse.fail(FeelingApiErrorCode.FEEL_NOT_EXIST, "该条feel不存在");
        }
        //未知错误
        return FeelingResponse.fail(FeelingApiErrorCode.UN_KNOW, "未知错误");
    }

}
