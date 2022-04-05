package com.hehe.design.coupon;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class CouponService {

    public CouponResult sendCoupon(String uId,String couponNUmber,String uuid) {

        System.out.println("模拟发放优惠券一张:" + uId + "," + couponNUmber + "," + uuid);
        return new CouponResult("0000","发放成功");
    }
}
