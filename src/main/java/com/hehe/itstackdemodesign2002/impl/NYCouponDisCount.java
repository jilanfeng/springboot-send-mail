package com.hehe.itstackdemodesign2002.impl;

import com.hehe.itstackdemodesign2002.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class NYCouponDisCount implements ICouponDiscount<Double> {

    /**
     * n元购买 无论多少钱固定金额购买
     *
     * @param couponInfo 券折扣计算信息：直减,满减，折扣，N元购
     * @param skuPrice sku金额
     * @return
     */
    @Override
    public BigDecimal discount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
