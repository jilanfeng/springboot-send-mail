package com.hehe;

import com.hehe.web.AbstractFactory.Provider;
import com.hehe.web.AbstractFactory.SendMailFactory;
import com.hehe.web.AbstractFactory.Sender;

/**
 * @author 刘伟锋
 * @date 2020/12/31
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.producer();
        sender.send();
    }

    /**
     *  其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，则需要做一个实现类，实现Sender接口，同时做一个工厂类，实现provider接口，就OK了，无需去改现成的的代码。这样做，扩展性好
     *
     *
     */
}
