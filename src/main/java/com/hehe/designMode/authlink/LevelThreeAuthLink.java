package com.hehe.designMode.authlink;

import java.text.ParseException;
import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/18
 **/
public class LevelThreeAuthLink extends AuthLink {


    private Date beginDate = f.parse("2022-02-16 23:56:45");
    private Date endDate = f.parse("2022-02-20 23:56:45");

    public LevelThreeAuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号:", orderId, "状态：待三级审批负责人", levelUserName);
        }
        AuthLink next = super.getNext();

        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, "状态：三级审批完成负责人", "时间：", f.format(date), "审批人：", levelUserName);

        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000","单号：",orderId," 状态：三级审批 完成负责人"," 时间",f.format(date),"审批人：" ,levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);

    }
}
