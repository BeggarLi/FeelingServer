package com.li.feeling.feellist;

import com.li.feeling.feellist.service.FeelListServiceImpl;
import com.li.feeling.model.Feel;
import com.li.feeling.net.FeelingErrorCode;
import com.li.feeling.net.FeelingException;
import com.li.feeling.net.FeelingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeelListController {

    private FeelListServiceImpl mFeelListService;

    public FeelingResponse<Feel> getFeelListData(){
        System.out.println("receive FeelList request");
        if(true){
            throw new FeelingException(FeelingErrorCode.FEELING_LIST_ERROR,"Feel列表请求失败");
        }
        Feel feel = mFeelListService.getFeelListData();
        return FeelingResponse.success(feel);
    }
}
