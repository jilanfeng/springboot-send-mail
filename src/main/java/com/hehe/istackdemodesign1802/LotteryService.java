package com.hehe.istackdemodesign1802;

import com.hehe.istackdemodesign1802.event.EventManager;
import com.hehe.istackdemodesign1802.event.listener.MQEventListener;
import com.hehe.istackdemodesign1802.event.listener.MessageEventListener;

/**
 * @author 刘伟锋
 * @date 2022/01/08
 **/
public abstract class LotteryService {

    private EventManager eventManager;


    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ,EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message,new MessageEventListener());
    }


    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ,lotteryResult);
        eventManager.notify(EventManager.EventType.Message,lotteryResult);
        return lotteryResult;

    }
    protected abstract LotteryResult doDraw(String uId);
}
