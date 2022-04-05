package com.hehe.designMode.adapter;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 刘伟锋
 * @date 2022/02/24
 **/
@SpringBootTest
class MQAdapterTest {
    @Test
    void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Create_account create_account = new Create_account();
        create_account.setNumber("10001");
        create_account.setAddress("广东省.深圳市.南山区.南方科技大学");
        create_account.setAccountDate(new Date());
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");

        RebateInfo rebateInfo01 = MQAdapter.filter(create_account.toString(), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("10001");
        orderMq.setSku("10908092093111123");
        orderMq.setCreateOrderTime(new Date());

        HashMap<String, String> link02 = new HashMap<>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));

    }

}