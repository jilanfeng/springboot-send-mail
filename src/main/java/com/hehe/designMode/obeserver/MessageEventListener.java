package com.hehe.designMode.obeserver;

import com.hehe.istackdemodesign1802.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 监听事件
 * 短消息事件
 *
 * @author 刘伟锋
 * @date 2022/02/23
 **/
public class MessageEventListener implements EventListener {
    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知（短信）:{}", result.getuId(), result.getMsg());
    }
}
