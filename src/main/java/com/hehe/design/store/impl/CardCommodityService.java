package com.hehe.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.hehe.design.card.IQiCardService;
import com.hehe.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class CardCommodityService implements ICommodity {


    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);


    //模拟注入
    private IQiCardService iQiCardService = new IQiCardService();
    @Override
    public void sendCommodity(String uid, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uid);
        iQiCardService.grantToken(mobile,bizId);
        logger.info("请求参数【爱奇艺兑换卡】 =》 uid:{} commodityId:{} bizId:{} extMap:{}",uid,commodityId,bizId, JSON.toJSON(extMap));
        logger.info("测试结果【爱奇艺兑换卡】:success");
    }

    private String queryUserMobile(String uid) {
     return "15177327566";
    }
}
