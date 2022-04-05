package com.hehe.smallspring.smallspringstep01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘伟锋
 * @date 2022/02/27
 **/
@SpringBootTest
class BeanFactoryTest {

    /**
     * 在测试中主要包括初始化Bean工厂，注册Bean ,获取Bean 三个步骤，使用效果贴近于Spring，但显得会更简化。
     *
     * 在Bean 的注册中，这里是直接UserService 实例化后作为入参传递给BeanDefinition的，在后续的陆续实现中，我们会把这部分内容放入Bean 工厂中实现。
     */
    @Test
    void test_BeanFactory() {
        //1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2.注册Bean

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3.获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


}