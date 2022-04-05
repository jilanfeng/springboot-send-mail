package com.hehe.designMode.bridge;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2022/03/01
 **/
public class WxPay extends Pay {

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟微信渠道支付划账开始。uId:{} traderId:{} amount:{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟微信渠道支付风控校验。uId:{},tradeId:{},security:{}", uId, tradeId, amount);
        if (!security) {
            logger.info("模拟为日信息渠道支付划账拦截。uId:{} tradeId:{} amount:{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟微信渠道支付划账成功。uId ：{} tradeId:{} amount:{}", uId, tradeId, amount);
        return "0000";
    }
}
