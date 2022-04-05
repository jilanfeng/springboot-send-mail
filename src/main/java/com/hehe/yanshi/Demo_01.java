package com.hehe.yanshi;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘伟锋
 * @date 2021/05/01
 **/
public class Demo_01 {
    public static void main(String[] args) {
        //通过spring标签定义一个bean <bean/>
        //@Component
        //@Bean
//        BeanDefinition


//        编程式 BeanDefinition    声明式
//
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(config.class);
//        User user1 = context.getBean("user", User.class);

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(config.class);
        User user2 = context1.getBean("user", User.class);


//        method();
    }

    private static void method() {
        int c = method2(1, 2);
        System.out.println(c);
    }

    private static int method2(int i, int i1) {
        return i+i1;
    }
}
