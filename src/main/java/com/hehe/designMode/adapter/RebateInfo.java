package com.hehe.designMode.adapter;

import java.util.Date;

/**
 * 统一的MQ消息体
 *
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class RebateInfo {


    /**
     * 用户ID
     */
    private String userId;

    /**
     * 业务Id
     */
    private String bizId;

    /**
     * 业务时间
     */
    private Date bizTime;

    /**
     * 业务描述
     */
    private String desc;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
