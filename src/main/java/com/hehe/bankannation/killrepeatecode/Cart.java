package com.hehe.bankannation.killrepeatecode;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Data
public class Cart {
    /**
     * 商品清单
     */
    private List<Item> items = new ArrayList<>();


    /**
     * 总折扣
     */
    private BigDecimal totalDiscount;

    /**
     * 商品总价
     */
    private BigDecimal totalItemPrice;


    /**
     * 总运费
     */
    private BigDecimal totalDeliveryPrice;


    /**
     * 应付总价
     */
    private BigDecimal payPrice;
}
