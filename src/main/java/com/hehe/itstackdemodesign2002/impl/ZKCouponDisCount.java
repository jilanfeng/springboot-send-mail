package com.hehe.itstackdemodesign2002.impl;

import com.hehe.itstackdemodesign2002.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class ZKCouponDisCount implements ICouponDiscount<Double> {
    /**
     * 折扣计算
     * 1.使用商品价格乘于折扣比例，为最后金额
     *
     * 2.保留两位小数
     *
     * 3.最低支付金额1元
     *
     * @param couponInfo 券折扣计算信息：直减,满减，折扣，N元购
     * @param skuPrice sku金额
     * @return
     */
    @Override
    public BigDecimal discount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);

        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
