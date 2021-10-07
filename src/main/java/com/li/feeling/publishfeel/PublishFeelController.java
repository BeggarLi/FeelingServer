package com.li.feeling.publishfeel;

import com.li.feeling.model.Feel;
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
            @RequestParam("contentText") String contentText){
        System.out.println("receive publish request");

        mPublishServiceImpl.publish(userId,contentText);
        // TODO: 2021/10/7 先写死成功
        return FeelingResponse.success(true);
    }
}
