package com.hehe.designMode.obeserver;

import com.hehe.istackdemodesign1802.LotteryResult;

/**
 * 接口中定义了基本的事件类，这里如果方法的入参信息类型是变化的可以使用泛型</T>
 *
 * @author 刘伟锋
 * @date 2022/02/23
 **/
public interface EventListener {
    void doEvent(LotteryResult result);
}
