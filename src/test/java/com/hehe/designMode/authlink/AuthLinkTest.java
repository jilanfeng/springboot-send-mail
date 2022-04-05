package com.hehe.designMode.authlink;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/18
 **/
@SpringBootTest
class AuthLinkTest {
    private Logger logger = LoggerFactory.getLogger(AuthLinkTest.class);

    @Test
    void test_AuLink() throws ParseException {
        AuthLink authLink = new LevelThreeAuthLink("100013", "周工")
                .appendNext(new LevelTwoAuthLink("100012", "孙经理")
                        .appendNext(new LevelOneAuthLink("100011", "张董")));
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("s9712222", "10000555566313131", new Date())));


        //模拟三级负责人审批
        AuthService.auth("100013", "10000555566313131");
        logger.info("测试结果:{}", "模拟三级负责人审批，周工");
        logger.info("测试结果:{}", JSON.toJSONString(authLink.doAuth("s9712222", "10000555566313131", new Date())));


        //模拟二负责人审批
        AuthService.auth("100012", "10000555566313131");
        logger.info("测试结果:{}", "模拟二级负责人审批，孙经理");
        logger.info("测试结果:{}", JSON.toJSONString(authLink.doAuth("s9712222", "10000555566313131", new Date())));


        //模拟一级负责人审批
        AuthService.auth("100011", "10000555566313131");
        logger.info("测试结果:{}", "模拟一级负责人审批，张总");
        logger.info("测试结果:{}", JSON.toJSONString(authLink.doAuth("s9712222", "10000555566313131", new Date())));

    }

}