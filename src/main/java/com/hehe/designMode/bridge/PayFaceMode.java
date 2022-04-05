package com.hehe.designMode.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/03/01
 **/
public class PayFaceMode implements IPayMode {

    private Logger logger = LoggerFactory.getLogger(PayFaceMode.class);

    @Override
    public boolean security(String uId) {
        logger.info("人脸支付,风控校验脸部识别");
        return true;
    }
}
