package com.hehe.web.AbstractFactory;

/**
 * @author 刘伟锋
 * @date 2020/12/31
 **/
public class SendSmsFactory implements Provider {
    @Override
    public Sender producer() {
        return new SmsSender();
    }
}
