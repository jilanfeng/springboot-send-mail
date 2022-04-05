package com.hehe.bankannation.killrepeatecode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/07
 **/
public class VipUserCart {

    public Cart process(long userId, Map<Long,Integer> items) {

        Cart cart = new Cart();

        List<Item> itemList = new ArrayList<>();
        items.forEach((key,value)-> {
            Item item = new Item();
            item.setId(key);
            item.setPrice(getItemPrice(key));
            item.setQuantity(value);
            itemList.add(item);
        });
        cart.setItems(itemList);
        itemList.forEach(item -> {
            //运费为商品总价的10%
            item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).multiply(new BigDecimal("0.1")));
            //购买两件以上相同商品，第三件开始享受一定折扣
            if (item.getQuantity() >2) {
                item.setCouponPrice(item.getPrice().multiply(BigDecimal.valueOf(100-getUserCouponPercent(userId))
                        .divide(new BigDecimal("100"))).multiply(BigDecimal.valueOf(item.getQuantity() -2)));
            } else {
                item.setCouponPrice(BigDecimal.ZERO);
            }
        });
        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
        .reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setTotalDeliveryPrice(cart.getItems().stream()
        .map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setTotalDiscount(cart.getItems().stream()
        .map(Item::getCouponPrice).reduce(BigDecimal.ZERO,BigDecimal::add));
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        return cart;
    }

    private int getUserCouponPercent(long userId) {
        return 20;
    }

    private BigDecimal getItemPrice(Long key) {
        return BigDecimal.valueOf(300);
    }
}
