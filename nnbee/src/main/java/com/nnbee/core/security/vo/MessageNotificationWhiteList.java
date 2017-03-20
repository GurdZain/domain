package com.nnbee.core.security.vo;

/**
 * Created by Tao on 2016/7/7 0007.
 */
public class MessageNotificationWhiteList {

    private Long whiteListId;
    private String identifying;
    private String describe;

    public Long getWhiteListId() {
        return whiteListId;
    }

    public void setWhiteListId(Long whiteListId) {
        this.whiteListId = whiteListId;
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
