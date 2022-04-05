package com.hehe.designMode.bridge;

/**
 * 定义支付模式接口
 *
 * @author 刘伟锋
 * @date 2022/03/01
 **/
public interface IPayMode {

    /**
     * 安全风控
     *
     * @param uId
     * @return
     */
    boolean security(String uId);
}
