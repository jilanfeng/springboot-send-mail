package com.hehe.istackdemodesign1802.event;

import com.hehe.istackdemodesign1802.LotteryResult;
import com.hehe.istackdemodesign1802.event.listener.EventListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2022/01/03
 **/
public class EventManager {
    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    public enum EventType {
        MQ,Message
    }

    /**
     * 订阅
     *
     * @param eventType
     * @param listener
     */
    public void subscribe(Enum<EventType> eventType,EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }


    /**
     * 取消订阅
     *
     * @param eventType
     * @param listener
     */
    public void unSubScribe(Enum<EventType> eventType,EventListener listener) {


        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }


    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);

        for (EventListener eventListener : users) {
            eventListener.doEvent(result);
        }

    }
}
