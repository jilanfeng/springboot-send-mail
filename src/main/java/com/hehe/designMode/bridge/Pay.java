package com.hehe.designMode.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2022/03/01
 **/
public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 划账接口
     *
     * @param uId
     * @param tradeId
     * @param amount
     * @return
     */
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
