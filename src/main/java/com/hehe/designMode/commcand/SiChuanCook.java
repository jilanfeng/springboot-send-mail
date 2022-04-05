package com.hehe.designMode.commcand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class SiChuanCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    @Override
    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系");
    }
}
