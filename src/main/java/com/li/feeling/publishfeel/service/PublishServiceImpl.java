package com.li.feeling.publishfeel.service;

import com.li.feeling.model.Feel;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceImpl implements IPublishFeelService{
    @Override
    public Feel publish() {
        return new Feel();
    }
}
