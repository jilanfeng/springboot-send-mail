package com.hehe.designMode.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId) {
        logger.info("自营商家，查询用户的订单是否为首单:{}",userId);
        return 10L;
    }

}
