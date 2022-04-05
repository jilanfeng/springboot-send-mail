package com.hehe.designMode.commcand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class JiangsuCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(JiangsuCook.class);

    @Override
    public void doCooking() {
        logger.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
    }
}
