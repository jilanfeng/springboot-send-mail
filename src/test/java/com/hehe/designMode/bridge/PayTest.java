package com.hehe.designMode.bridge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2022/03/01
 **/
@SpringBootTest
class PayTest {
    @Test
    void test() {
        System.out.println("\r\n模拟测试场景：微信支付，人脸方式。");
        WxPay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_10923033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景:支付宝支付,指纹方式");
        ZfbPay zfbPay = new ZfbPay(new PayFingerPrintMode());
        zfbPay.transfer("jlu19dlco111", "100000109894", new BigDecimal(100));

    }

}