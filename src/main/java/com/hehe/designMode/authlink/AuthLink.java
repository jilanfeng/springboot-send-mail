package com.hehe.designMode.authlink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/17
 **/
public abstract class AuthLink {

    private Logger logger = LoggerFactory.getLogger(AuthLink.class);

    /**
     * 时间格式化
     */
    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 级别人员ID
     */
    protected String levelUserId;

    /**
     * 级别人员姓名
     */
    protected String levelUserName;

    /**
     * 责任链
     */
    public AuthLink next;


    public AuthLink getNext() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    /**
     * 处理逻辑
     *
     * @param uId
     * @param orderId
     * @param authDate
     * @return
     */
    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
