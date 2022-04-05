package com.hehe.itstackdemodesign2002;

import java.math.BigDecimal;

/**
 * 优惠券折扣计算接口
 *
 *
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public interface ICouponDiscount<T> {

    /**
     * 优惠券金额计算
     *
     * @param couponInfo 券折扣计算信息：直减,满减，折扣，N元购
     * @param skuPrice sku金额
     * @return         优惠后金额
     */
    BigDecimal discount(T couponInfo,BigDecimal skuPrice);
}
