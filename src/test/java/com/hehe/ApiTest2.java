package com.hehe;

import com.hehe.design.store.ICommodity;
import com.hehe.design.store.StoreFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
@SpringBootTest
public class ApiTest2 {
    @Test
    public void test_commodity() throws Exception {

        StoreFactory storeFactory = new StoreFactory();
        //1.优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001","EGM1023938910232121323432","791098764902132",null);

        //2.实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);
        Map<String,String> extMap = new HashMap<String,String>();

        extMap.put("consigneeUserName","liuweif");
        extMap.put("consigneeUserPhone","15177327556");
        extMap.put("consigneeUserAddress","广东省深圳市宝安区劳动二队一巷子21号704");
        commodityService_2.sendCommodity("10001","9820198721311","1023000020112221113",extMap);


        // 3.第三方兑换卡（爱奇艺）
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }
}
