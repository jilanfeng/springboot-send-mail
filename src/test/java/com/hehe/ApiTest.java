package com.hehe;

import com.alibaba.fastjson.JSON;
import com.hehe.design.AwardReq;
import com.hehe.design.AwardRes;
import com.hehe.design.PrizeController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_awardToUser() {
        PrizeController prizeController = new PrizeController();
        System.out.println("\r\n模拟发放优惠券测试\r\n");
        //模拟发放优惠券测试
        AwardReq req01 = new AwardReq();
        req01.setUId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");

        AwardRes awardRes01 = prizeController.awardToUser(req01);

        logger.info("请求参数:{}", JSON.toJSON(req01));
        logger.info("测试结果:{}",JSON.toJSON(awardRes01));

        System.out.println("\r\n模拟发放实物商品\r\n");
        //模拟发放实物商品
        AwardReq req02 = new AwardReq();
        req02.setUId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");
        req02.setExtMap(new HashMap<String,String>() {{
            put("consigneeUserName","jiabujia");
            put("consigneeUserPhone","15177327556");
            put("consingeeUserAddress","广东省深圳市区宝安区劳动二队一巷");
        }
        });
        AwardRes  awardRes02 = prizeController.awardToUser(req02);

        logger.info("请求参数:{}", JSON.toJSON(req02));
        logger.info("测试结果:{}",JSON.toJSON(awardRes02));

        System.out.println("\r\n第三方兑换卡(爱奇艺）\r\n");
        AwardReq req03 = new AwardReq();
        req03.setUId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");
        AwardRes awardRes03 = prizeController.awardToUser(req03);
        logger.info("请求参数:{}", JSON.toJSON(req03));
        logger.info("测试结果:{}",JSON.toJSON(awardRes03));


    }
}
