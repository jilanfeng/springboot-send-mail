package com.hehe.web.FactoryDesignMode;

/**
 * @author 刘伟锋
 * @date 2020/12/30
 **/
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mailsender!");
    }
}