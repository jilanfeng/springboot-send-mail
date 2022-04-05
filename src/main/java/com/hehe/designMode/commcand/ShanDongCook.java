package com.hehe.designMode.commcand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class ShanDongCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ShanDongCook.class);

    @Override
    public void doCooking() {
     logger.info("山东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }
}
