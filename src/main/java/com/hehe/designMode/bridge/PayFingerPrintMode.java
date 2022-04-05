package com.hehe.designMode.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/03/01
 **/
public class PayFingerPrintMode implements IPayMode {
    private Logger logger = LoggerFactory.getLogger(PayFingerPrintMode.class);

    @Override
    public boolean security(String uId) {
        logger.info("指纹支付,风控校验指纹信息");
        return true;
    }
}
