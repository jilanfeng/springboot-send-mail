package com.hehe.itstackdemodesign2002.impl;

import com.hehe.itstackdemodesign2002.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

    @Override
    public BigDecimal discount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("X");
        String o = couponInfo.get("O");

        // 小于商品金额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        // 减去优惠金额判断
        BigDecimal dicountAmount = skuPrice.subtract(new BigDecimal(o));

        if (dicountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return dicountAmount;

    }
}
