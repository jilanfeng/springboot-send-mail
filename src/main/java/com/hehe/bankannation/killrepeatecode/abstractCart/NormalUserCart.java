package com.hehe.bankannation.killrepeatecode.abstractCart;


import com.hehe.bankannation.killrepeatecode.AbstractCart;
import com.hehe.bankannation.killrepeatecode.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2021/10/08
 **/
@Service(value = "NormalUserCart")
public class NormalUserCart extends AbstractCart {
    @Override
    public void processCouponPrice(long userId, Item item) {
        item.setCouponPrice(BigDecimal.ZERO);
    }

    @Override
    public void processDeliveryPrice(long userId, Item item) {
        item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
        .multiply(new BigDecimal("0.1")));
    }
}
