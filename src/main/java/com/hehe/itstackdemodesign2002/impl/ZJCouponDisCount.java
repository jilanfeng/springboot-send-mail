package com.hehe.itstackdemodesign2002.impl;

import com.hehe.itstackdemodesign2002.ICouponDiscount;

import java.math.BigDecimal;


/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class ZJCouponDisCount implements ICouponDiscount<Double> {
    /**
     * 直减计算
     * 1.使用商品价格减去优惠价格
     * 2.最低支付金额1元
     *
     * @param couponInfo 券折扣计算信息：直减,满减，折扣，N元购
     * @param skuPrice sku金额
     * @return
     */
    @Override
    public BigDecimal discount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}
