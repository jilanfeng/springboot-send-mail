package com.hehe.designMode.memento;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author 刘伟锋
 * @date 2022/02/22
 **/
@SpringBootTest
class AdminTest {
    private Logger logger = LoggerFactory.getLogger(AdminTest.class);
    @Test
    void test() {
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();
        configOriginator.setConfigFile(new ConfigFile("10001","配置内容A=哈哈",new Date(),"小峰"));
        admin.append(configOriginator.saveMemento());


        configOriginator.setConfigFile(new ConfigFile("10002","配置内容A=嘻嘻",new Date(),"小峰"));
        admin.append(configOriginator.saveMemento());


        configOriginator.setConfigFile(new ConfigFile("10003","配置内容A=么么",new Date(),"小峰"));
        admin.append(configOriginator.saveMemento());

        configOriginator.setConfigFile(new ConfigFile("10003","配置内容A=嘿嘿",new Date(),"小峰"));
        admin.append(configOriginator.saveMemento());

        //历史配置
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置（回滚） undo:{}", toJSONString(configOriginator.getConfigFile()));



        //历史配置
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置（回滚） undo:{}", toJSONString(configOriginator.getConfigFile()));

        //历史前进
        configOriginator.getMemento(admin.redo());
        logger.info("历史配置（前进）redo:{}",JSON.toJSONString(configOriginator.getConfigFile()));

        //历史获取
        configOriginator.getMemento(admin.get("10002"));
        logger.info("历史配置（获取）redo:{}",JSON.toJSONString(configOriginator.getConfigFile()));


    }

}