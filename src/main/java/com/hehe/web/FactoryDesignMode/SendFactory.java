package com.hehe.web.FactoryDesignMode;

/**
 * @author 刘伟锋
 * @date 2020/12/30
 **/
public class SendFactory {
//    public Sender producer(String type) {
//        if ("mail".equals(type)) {
//            return new MailSender();
//        } else if ("sms".equals(type)) {
//            return new SmsSender();
//        } else {
//            System.out.println("请输出正确的类型！");
//            return null;
//        }
//    }

    /**
     * 多个工厂模式
     *
     * @return
     */
//    public Sender producerMail() {
//        return new MailSender();
//    }
//    public Sender produceSms() {
//        return new SmsSender();
//    }
    /**
     * 静态工厂模式
     */

    public static Sender producerMail() {
        return new MailSender();
    }

    public static Sender producerSms() {
        return new SmsSender();
    }
}
