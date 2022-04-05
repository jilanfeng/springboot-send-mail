package com.hehe.smallspring.smallspringstep01;

/**
 * 目前的Bean定义中，只有一个Object 用于存放Bean 对象，如果感兴趣可以参考spring 源码中这个类的信息，名称都是一样的。
 * 不过在后面陆续的视线中会逐步晚上BeanDefinition相关属性的填充，例如：SCOPE_SINGLETON,SCOPE_PROTOTYPE,ROLE_APPLICATION,
 * ROLE_SUPPORT,ROLE_INFRASTRUCTURE 以及Bean Class信息
 *
 * @author 刘伟锋
 * @date 2022/02/27
 **/
public class BeanDefinition {

    private Object Bean;


    public BeanDefinition(Object bean) {
        Bean = bean;
    }

    public Object getBean() {
        return Bean;
    }
}
