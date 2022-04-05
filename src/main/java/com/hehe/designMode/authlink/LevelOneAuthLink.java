package com.hehe.designMode.authlink;

import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/17
 **/
public class LevelOneAuthLink extends AuthLink {


    public LevelOneAuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号:", orderId, "状态：待一级审批负责人", levelUserName);
        }
        AuthLink next = super.getNext();

        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, "状态：一级审批完成负责人", "时间：", f.format(date), "审批人：", levelUserName);

        }

        return next.doAuth(uId, orderId, authDate);
    }

}
