package com.hehe.design.store;

import com.hehe.design.store.impl.CardCommodityService;
import com.hehe.design.store.impl.CouponCommodityService;
import com.hehe.design.store.impl.GoodsCommodityService;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if(null == commodityType) {
            return null;
        }
        if (1 == commodityType) {
            return new CouponCommodityService();
        }
        if(2 == commodityType) {
            return new GoodsCommodityService();
        }
        if(3 == commodityType) {
            return new CardCommodityService();
        }

    throw new RuntimeException("不存在的商品服务类型");
    }



}
