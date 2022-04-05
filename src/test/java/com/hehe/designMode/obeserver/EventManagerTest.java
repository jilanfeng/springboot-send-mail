package com.hehe.designMode.obeserver;

import com.alibaba.fastjson.JSON;
import com.hehe.istackdemodesign1802.LotteryResult;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘伟锋
 * @date 2022/02/23
 **/
@SpringBootTest
class EventManagerTest {

    private Logger logger = LoggerFactory.getLogger(EventManagerTest.class);

    @Test
    void test() {
        LotteryServiceImpl lotteryService = new LotteryServiceImpl();
        LotteryResult lotteryResult = lotteryService.draw("20112233332");
        logger.info("测试结果：{}", JSON
                .toJSONString(lotteryResult));
    }


}