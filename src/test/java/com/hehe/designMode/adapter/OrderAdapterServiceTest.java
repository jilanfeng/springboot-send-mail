package com.hehe.designMode.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author 刘伟锋
 * @date 2022/02/24
 **/
@SpringBootTest
class OrderAdapterServiceTest {
    @Test
    void test_ifAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单,接口适配(POP):" + popOrderAdapterService.isFirst("10001"));
        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单,接口适配(自营):" + insideOrderService.isFirst("10001"));
    }

}