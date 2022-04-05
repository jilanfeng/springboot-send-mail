package com.hehe.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.hehe.design.coupon.CouponResult;
import com.hehe.design.coupon.CouponService;
import com.hehe.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class CouponCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    private CouponService couponService =  new CouponService();
    @Override
    public void sendCommodity(String uid, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uid,commodityId,bizId);
        logger.info("请求参数【优惠群】 => uid:{} commodityId:{},bizId:{},extMap:{}",uid,commodityId,bizId, JSON.toJSON(extMap));
        logger.info("测试结果【优惠券】:{} ",JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }

    }
}
