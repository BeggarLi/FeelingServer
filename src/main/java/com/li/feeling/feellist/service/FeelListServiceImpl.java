package com.li.feeling.feellist.service;

import com.li.feeling.model.Feel;

public class FeelListServiceImpl implements IFeelListService{
    @Override
    public Feel getFeelListData() {
        return new Feel();
    }
}
