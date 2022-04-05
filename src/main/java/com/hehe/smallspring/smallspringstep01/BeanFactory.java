package com.hehe.smallspring.smallspringstep01;

import org.springframework.context.annotation.Lazy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在Bean工厂的实现中，包括了bean 的注册，这里的注册是Bean 的定义信息。同时在这个类中还包括了获取Bean 的操作。
 * 目前的Bean Factory 仍然是非常简化的实现，但这种简化的实现内容也是整个spring容器中关于Bean使用的最终体现结果，只不过实现过程只展现出基本的核心原理
 * 在后续的补充实现中，这个会不断变得庞大
 *
 * @author 刘伟锋
 * @date 2022/02/27
 **/
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
