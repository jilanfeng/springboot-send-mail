package com.hehe.bankannation.killrepeatecode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
public class NormalUserCart {

    public Cart process(long userId, Map<Long,Integer> items) {

        Cart cart = new Cart();

        //购物车Map 转为Item list

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
            //运费为商品总价的10%
            item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
                    .multiply(new BigDecimal( "0.1")));
            // 无优惠
            item.setCouponPrice(BigDecimal.ZERO);
        });

        // 计算纯商品总价
        cart.setTotalItemPrice(cart.getItems().stream()
        .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal.ZERO,BigDecimal::add));
        // 计算运费总价
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
       // 计算总优惠
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
       // 应付商品总价=商品总价+ 运费总价-总优惠
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        return cart;
    }

    private BigDecimal getItemPrice(Long key) {
        return BigDecimal.valueOf(300);
    }

}
