package com.hehe.designMode.bridge;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/03/01
 **/
public class PayCypher implements IPayMode {

    private Logger logger = LoggerFactory.getLogger(PayCypher.class);

    @Override
    public boolean security(String uId) {
        logger.info("密码支付，风控校验环境安全");
        return true;
    }
}
