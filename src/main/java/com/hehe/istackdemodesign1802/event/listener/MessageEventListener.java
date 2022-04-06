package com.hehe.istackdemodesign1802.event.listener;

import com.hehe.istackdemodesign1802.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/01/03
 **/
public class MessageEventListener implements EventListener {


    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {

        logger.info("给用户 {} 发送短信通知：{}", result.getuId(), result.getMsg());

    }
}
