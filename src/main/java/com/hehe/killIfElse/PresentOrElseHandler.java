package com.hehe.killIfElse;

import java.util.function.Consumer;

/**
 * @author 刘伟锋
 * @date 2021/12/04
 **/

public interface PresentOrElseHandler<T extends Object> {

    /**
     * 空值与不空值处理
     *
     * @param action
     * @param emptyAction
     */
    void presentOrElseHandle(Consumer<? super T> action,Runnable emptyAction);
}
