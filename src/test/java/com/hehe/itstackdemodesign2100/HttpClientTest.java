package com.hehe.itstackdemodesign2100;

import com.hehe.itstackdemodesign2100.impl.JDNetMall;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
@SpringBootTest
class HttpClientTest {

    public Logger logger = LoggerFactory.getLogger(HttpClientTest.class);


     /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.htm
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    void doGet() {
        NetMall jdNetMall = new JDNetMall("100000001", "********");
        String base64 = jdNetMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}",base64);

    }
}