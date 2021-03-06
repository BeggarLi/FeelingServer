package com.li.feeling.publishfeel;

import com.li.feeling.model.Feel;
import com.li.feeling.net.FeelingApiErrorCode;
import com.li.feeling.net.FeelingResponse;
import com.li.feeling.publishfeel.service.PublishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishFeelController {

    @Autowired
    private PublishServiceImpl mPublishServiceImpl;

    @PostMapping("/feeling/feel/publish")
    public FeelingResponse<Feel> publish(
            @RequestParam("userId") long userId,
            @RequestParam("contentText") String contentText) {
        System.out.println("receive publish request");

        Feel feel = mPublishServiceImpl.publish(userId, contentText);
        return feel != null
                ? FeelingResponse.success(true)
                : FeelingResponse.fail(FeelingApiErrorCode.UN_KNOW, "请稍后再试");
    }
}
