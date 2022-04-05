package com.hehe.istackdemodesign1802;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘伟锋
 * @date 2022/01/08
 **/
@SpringBootTest
class LotteryServiceTest {

    private Logger logger = LoggerFactory.getLogger(LotteryServiceTest.class);

    @Test
    void draw() {

        LotteryServiceImpl lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.draw("3152052051601");
        logger.info("测试结果:{}", JSON.toJSONString(result));

    }

    @Test
    void doDraw() {
    }
}