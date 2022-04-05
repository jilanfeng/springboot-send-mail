package com.hehe.bankannation.killrepeatecode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/07
 **/
public abstract class AbstractCart {

    /**
     *  重构秘技 - 模板方法模式
     *
     * 可以把重复逻辑定义在抽象类，三个购物车只要分别实现不同部分的逻辑
     *
     * 这其实就是模板方法模式
     * 在父类中实现购物车处理的流程模板，然后把需要特殊处理的留抽象方法定义，让子类去实现，由于父类逻辑无法单独
     * 工作，因此需要定义为抽象类，
     */


    public Cart process(long userId, Map<Long,Integer> items) {

        Cart cart = new Cart();
        List<Item> itemList = new ArrayList<>();
        items.forEach((key,value) -> {
            Item item = new Item();
            item.setId(key);
            item.setPrice(getItemPrice(key));
            item.setQuantity(value);
            itemList.add(item);
        });

        cart.setItems(itemList);
        itemList.forEach(item -> {
            processCouponPrice(userId,item);
            processDeliveryPrice(userId,item);
        });

        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice()
        .multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        return cart;
    }

    public abstract void processCouponPrice(long userId, Item item);

    public abstract void processDeliveryPrice(long userId, Item item);

    private BigDecimal getItemPrice(Long key) {
        return BigDecimal.valueOf(500);
    }
}
