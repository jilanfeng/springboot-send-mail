package com.hehe.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.hehe.design.goods.DeliverReq;
import com.hehe.design.goods.GoodsService;
import com.hehe.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class GoodsCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    private GoodsService goodsService= new GoodsService();

    @Override
    public void sendCommodity(String uid, String commodityId, String bizId, Map<String, String> extMap) throws Exception {

        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uid));
        deliverReq.setUserPhone(queryUserPhoneNumber(uid));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consingeeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[优惠券】 = 》 uid ：{} commodityId:{} bizId :{} exMap:{}",uid,commodityId,bizId, JSON.toJSON(extMap));
        logger.info("测试结果【优惠券】:{}",isSuccess);
        if(!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    private String queryUserPhoneNumber(String uid) {
        return "15177327556";
    }

    private String queryUserName(String uid) {
        return "liuweif";
    }
}
