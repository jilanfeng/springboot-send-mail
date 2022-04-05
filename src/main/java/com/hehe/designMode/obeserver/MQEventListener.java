package com.hehe.designMode.obeserver;

import com.hehe.istackdemodesign1802.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 监听事件
 * MQ 发送事件
 *
 * @author 刘伟锋
 * @date 2022/02/23
 **/
public class MQEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户 {} 摇号结果（MQ）：{}", result.getuId(), result.getMsg());
    }
}
