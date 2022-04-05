package com.hehe.itstackdemodesign2002;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice) {
        return  couponDiscount.discount(couponInfo,skuPrice);
    }
}
