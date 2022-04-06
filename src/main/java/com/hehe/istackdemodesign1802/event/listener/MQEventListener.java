package com.hehe.istackdemodesign1802.event.listener;

import com.hehe.istackdemodesign1802.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/01/03
 **/
public class MQEventListener implements EventListener {
    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {

        logger.info("记录用户{}，摇号结果（MQ):{}", result.getuId(), result.getMsg());
    }
}
