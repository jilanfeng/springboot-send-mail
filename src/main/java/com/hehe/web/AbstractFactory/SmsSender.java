package com.hehe.web.AbstractFactory;

/**
 * @author 刘伟锋
 * @date 2020/12/31
 **/
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is sms sender!");
    }
}