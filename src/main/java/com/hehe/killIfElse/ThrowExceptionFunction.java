package com.hehe.killIfElse;

/**
 * 抛异常接口
 *
 * @author 刘伟锋
 * @date 2021/11/25
 **/
@FunctionalInterface
public interface ThrowExceptionFunction {

    /**
     * 抛出异常信息
     *
     * @param message 异常信息
     * @return void
     */
    void throwMessage(String message);

}
