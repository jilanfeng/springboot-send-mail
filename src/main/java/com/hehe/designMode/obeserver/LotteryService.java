package com.hehe.designMode.obeserver;

import com.hehe.istackdemodesign1802.LotteryResult;

/**
 * 业务抽象接口
 *
 * @author 刘伟锋
 * @date 2022/02/23
 **/
public abstract class LotteryService {
    private EventManager eventManager;


    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        //需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
