package com.hehe.web.AbstractFactory;

/**
 * @author εδΌι
 * @date 2020/12/31
 **/
public class SendMailFactory implements Provider {
    @Override
    public Sender producer() {
        return new MailSender();
    }
}
