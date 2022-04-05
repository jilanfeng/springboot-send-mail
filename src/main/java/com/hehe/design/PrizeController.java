package com.hehe.design;

import com.alibaba.fastjson.JSON;
import com.hehe.design.card.IQiCardService;
import com.hehe.design.coupon.CouponResult;
import com.hehe.design.coupon.CouponService;
import com.hehe.design.goods.DeliverReq;
import com.hehe.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class PrizeController {

    private Logger logger =  LoggerFactory.getLogger(PrizeController.class);


    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("奖品开始发放，req：{}",req.getUId(),reqJson);
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000","发放成功");
                } else {
                    awardRes = new AwardRes("0001",couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(querUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consignUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUseAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000","发放成功");
                } else {
                    awardRes = new AwardRes("0001","发放失败");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNUmber = querUserPhoneNumber(req.getUId());
                IQiCardService iQiCardService = new IQiCardService();
                iQiCardService.grantToken(bindMobileNUmber,req.getAwardNumber());
                awardRes = new AwardRes("0000","发放成功");
            }
            logger.info("奖品发放完成，{}",req.getUId());
        } catch (Exception e) {
            logger.error("奖品发放失败{},req:{}",req.getUId(),reqJson,e);
        }
        return awardRes;
    }

    private String querUserPhoneNumber(String uId) {
        return "15177327556";
    }

    private String queryUserName(String uId) {
        return "huahua";
    }
}
