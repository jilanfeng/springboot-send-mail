package com.hehe.itstackdemodesign2002;

import com.hehe.itstackdemodesign2002.impl.MJCouponDiscount;
import com.hehe.itstackdemodesign2002.impl.NYCouponDisCount;
import com.hehe.itstackdemodesign2002.impl.ZJCouponDisCount;
import com.hehe.itstackdemodesign2002.impl.ZKCouponDisCount;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
@SpringBootTest
class ContextTest {

    private Logger logger = LoggerFactory.getLogger(ContextTest.class);

    @Test
    void discountAmount_ZJ() {
        // 直减
        Context<Double> doubleContext = new Context<>(new ZJCouponDisCount());
        BigDecimal disCount = doubleContext.discountAmount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后金额 {}",disCount);

    }


    @Test
    void discountAmount_MJ() {
        // 直减
        Context<Map<String, String>> mapContext = new Context<>(new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<>();
        mapReq.put("X","100");
        mapReq.put("O","10");
        BigDecimal disCount = mapContext.discountAmount(mapReq, new BigDecimal(100));
        logger.info("测试结果：满减优惠后金额 {}",disCount);

    }

    @Test
    void discountAmount_ZK() {
        // 直
        Context<Double> doubleContext = new Context<>(new ZKCouponDisCount());
        BigDecimal disCount = doubleContext.discountAmount(0.9D, new BigDecimal(100));
        logger.info("测试结果：折扣九折后金额 {}",disCount);

    }

    @Test
    void discountAmount_NYG() {
        // 直减
        Context<Double> doubleContext = new Context<>(new NYCouponDisCount());
        BigDecimal disCount = doubleContext.discountAmount(90D, new BigDecimal(100));
        logger.info("测试结果：n元购优惠后金额 {}",disCount);

    }
}