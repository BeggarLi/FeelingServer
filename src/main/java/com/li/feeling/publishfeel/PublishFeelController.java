package com.li.feeling.publishfeel;

import com.li.feeling.model.Feel;
import com.li.feeling.net.FeelingResponse;
import com.li.feeling.publishfeel.service.PublishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishFeelController {

    @Autowired
    private PublishServiceImpl mPublishServiceImpl;

    @PostMapping("/feeling/user/publish")
    public FeelingResponse<Feel> publish(){
        System.out.println("receive publish request");

        Feel feel = mPublishServiceImpl.publish();
        return FeelingResponse.success(feel);
    }
}
