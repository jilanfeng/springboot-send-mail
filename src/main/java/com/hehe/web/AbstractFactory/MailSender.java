package com.hehe.web.AbstractFactory;

/**
 * @author εδΌι
 * @date 2020/12/31
 **/
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mailsender");
    }
}
