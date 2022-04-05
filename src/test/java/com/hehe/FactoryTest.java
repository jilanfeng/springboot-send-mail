package com.hehe;

import com.hehe.web.FactoryDesignMode.SendFactory;
import com.hehe.web.FactoryDesignMode.Sender;

/**
 * @author 刘伟锋
 * @date 2020/12/30
 **/
public class FactoryTest {
    public static void main(String[] args) {
//        SendFactory factory = new SendFactory();
//        Sender sender = factory.producer("sms");
//        sender.send();
/**
 * 多个工厂设计模式
 */
//        SendFactory factory = new SendFactory();
//        Sender sender = factory.producerMail();
//        sender.send();

        /**
         * 静态工厂模式
         */
        Sender sender = SendFactory.producerMail();
        sender.send();

    }
    /**
     * 总体来说，工厂模式适合：凡是出现大量的产品需要创建，并且具有共同的接口时，
     *
     *可以通过工厂方法模式创建。在以上三种模式中，第一种如果传入的字符串有误，不能正确创建对象
     * 第三种相对第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种静态工厂方法模式
     *
     *
     *
     *
     *
     *
     *
     */

}
