package com.hehe.killIfElse;

/**
 * 分支处理接口
 *
 * @author 刘伟锋
 * @date 2021/12/03
 **/
@FunctionalInterface
public interface BranchHandle {

    /**
     * 分支操作
     *
     * @param trueHandle 为true 时要进行的操作
     * @param falseHandle 为false 时要进行 的操作
     */
    void trueOrFalseHandle(Runnable trueHandle,Runnable falseHandle);

    /**
     * 抛出异常信息
     *
     * @param message 异常信息
     * @return void
     */
    @Override
    String toString();
}

