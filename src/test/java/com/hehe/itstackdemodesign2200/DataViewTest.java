package com.hehe.itstackdemodesign2200;

import com.hehe.itstackdemodesign2200.visitor.impl.Parent;
import com.hehe.itstackdemodesign2200.visitor.impl.Principal;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
@SpringBootTest
class DataViewTest {
private Logger logger = LoggerFactory.getLogger(DataViewTest.class);
    @Test
    void show() {
        DataView dataView = new DataView();

        logger.info("\r\n家长访问视角:");
        dataView.show(new Parent());



        logger.info("\r\n校长访问视角:");
        dataView.show(new Principal());

    }
}