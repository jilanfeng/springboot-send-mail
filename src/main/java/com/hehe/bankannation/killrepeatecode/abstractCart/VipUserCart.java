package com.hehe.bankannation.killrepeatecode.abstractCart;

import com.hehe.bankannation.killrepeatecode.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author εδΌι
 * @date 2021/10/08
 **/
@Service(value = "VipUserCart")
public class VipUserCart extends NormalUserCart {

    @Override
    public void processCouponPrice(long userId, Item item) {

        if (item.getQuantity() > 2 ) {
            item.setCouponPrice(item.getPrice().multiply(BigDecimal.valueOf(100-getUserCouponPercent(userId)).divide(new BigDecimal("100")))
            .multiply(BigDecimal.valueOf(item.getQuantity() -2)));
        } else{
            item.setCouponPrice(BigDecimal.ZERO);
        }

    }

    private int getUserCouponPercent(long userId) {
        return 20;
    }

}
