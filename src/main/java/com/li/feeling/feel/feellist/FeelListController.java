package com.li.feeling.feel.feellist;

import com.li.feeling.feel.IFeelService;
import com.li.feeling.model.Feel;
import com.li.feeling.net.FeelingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeelListController {

    @Autowired
    private IFeelService mFeelListService;

    @PostMapping("/feeling/feel/list")
    public FeelingResponse<Feel> getFeelListData() {
        System.out.println("receive feelList request");
        List<Feel> feelList = mFeelListService.getFeelList();
        FeelListResponse response = new FeelListResponse(feelList, "没有啦");
        return FeelingResponse.success(response);
    }
}
