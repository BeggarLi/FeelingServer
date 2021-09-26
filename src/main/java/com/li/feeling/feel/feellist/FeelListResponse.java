package com.li.feeling.feel.feellist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.li.feeling.model.Feel;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * description: feel列表接口的返回
 */
public class FeelListResponse implements Serializable {

    @JsonProperty("feelList")
    @NonNull
    public List<Feel> mFeelList; // 列表数据

    @JsonProperty("footerTip")
    public String mFooterTip; // 底部提示(前段滑到底部时的提示)

    public FeelListResponse(@NonNull List<Feel> mFeelList, String mFooterTip) {
        this.mFeelList = mFeelList;
        this.mFooterTip = mFooterTip;
    }
}
