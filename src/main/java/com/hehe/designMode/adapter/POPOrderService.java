package com.hehe.designMode.adapter;

import org.checkerframework.checker.guieffect.qual.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class POPOrderService {
    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uId) {
        logger.info("POP商家,查询用户的订单是否为首单:{}", uId);
        return true;
    }
}
