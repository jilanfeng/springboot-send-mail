package com.hehe.istackdemodesign1802.event.listener;

import com.hehe.istackdemodesign1802.LotteryResult;

/**
 * @author 刘伟锋
 * @date 2022/01/03
 **/
public interface EventListener {

    /**
     * 监听处理
     *
     * @param result  得到的结果
     */
    void doEvent(LotteryResult result);
}
