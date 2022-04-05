package com.hehe.designMode.commcand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class GuaangDongCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(GuaangDongCook.class);

    @Override
    public void doCooking() {
        logger.info("广东厨师烹饪粤菜，宫廷最大菜系");
    }
}
