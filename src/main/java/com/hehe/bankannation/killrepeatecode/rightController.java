package com.hehe.bankannation.killrepeatecode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/08
 **/
public class rightController {

    private BeanFactory applicationContext;

    /**
     * 既然三个购物车都叫XXXUserCart，可将用户类型字符串拼接Usercart 构成现在购物车Bean的名称，然后利用Ioc容器，通过Bean的名称直接获取AbstractCart，调用其process方法即可实现通用
     * 这就是工厂模式，借助Spring容器实现
     *
     * 若用新用户类型，用户逻辑，只要新增一个XXXUserCart继承AbstractCart ,实现特殊的优惠和运费处理逻辑即可
     *
     * 工厂+ 模板方法模式，消除了重复代码，这避免修改既有代码，这就是设计模式原则中的开闭原则：对修改关闭，对拓展开发
     *
     * @param userId
     * @return
     */
    @GetMapping("clean")
    public Cart right(@RequestParam("userId") int userId, Map<Long,Integer> items) {
        String userCategory = getUserCategory(userId);
        AbstractCart cart = (AbstractCart) applicationContext.getBean(userCategory + "UserCart");
        return cart.process(userId,items);
    }

    private String getUserCategory(int userId) {
        return null;
    }

}
