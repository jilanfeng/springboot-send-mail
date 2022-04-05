package com.hehe.bankannation.killrepeatecode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/07
 **/
public class InternalUserCart {
    public Cart process(long userId, Map<Long,Integer> items) {

        Cart cart = new Cart();

        List<Item> itemsList = new ArrayList<>();
        items.forEach((key,value) -> {
            Item item = new Item();
            item.setId(key);
            item.setPrice(getItemPrice(key));
            item.setQuantity(value);
            itemsList.add(item);
        });

        itemsList.forEach(item -> {
            //免运费
            item.setDeliveryPrice(BigDecimal.ZERO);
            //无优惠
            item.setCouponPrice(BigDecimal.ZERO);
        });
        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice()
        .multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));

        return cart;

    }

    private BigDecimal getItemPrice(Long key) {
      return BigDecimal.valueOf(600);
    }

}
