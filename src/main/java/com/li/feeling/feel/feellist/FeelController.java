package com.li.feeling.feel.feellist;

import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
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
    public FeelingResponse<Feel> getHomeFeelListData() {
        System.out.println("receive feelList request");
        List<Feel> feelList = mFeelService.getHomeFeelList();
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }

    // 获取用户自己发布的feel列表数据
    @PostMapping("/feeling/feel/user/published/list")
    public FeelingResponse<Feel> getUserPublishedFeelListData(@RequestParam("userId") long userId) {
        System.out.println("receive feelList request");
        List<Feel> feelList = mFeelService.getUserPublishedFeelList(userId);
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }

    // 获取用户点赞的feel列表数据
    @PostMapping("/feeling/feel/user/like/list")
    public FeelingResponse<Feel> getUserLikeFeelListData(@RequestParam("userId") long userId) {
        System.out.println("receive feelList request");
        List<Feel> feelList = mFeelService.getUserLikeFeelList(userId);
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }

}
