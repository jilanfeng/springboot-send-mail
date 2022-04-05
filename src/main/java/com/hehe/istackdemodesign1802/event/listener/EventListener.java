package com.hehe.istackdemodesign1802.event.listener;

import com.hehe.istackdemodesign1802.LotteryResult;

/**
 * @author 刘伟锋
 * @date 2022/01/03
 **/
public interface EventListener {

    /**
     *
     * @param result
     */
    void doEvent(LotteryResult result);
}
