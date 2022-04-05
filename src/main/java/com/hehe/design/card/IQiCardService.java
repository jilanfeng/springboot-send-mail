package com.hehe.design.card;

/**
 * 模拟爱奇艺会员卡服务
 *
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class IQiCardService {
    public void grantToken(String bindMobileNumber,String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张:" + bindMobileNumber + "," + cardId);
    }

}
