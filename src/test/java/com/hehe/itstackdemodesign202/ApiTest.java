package com.hehe.itstackdemodesign202;

import com.hehe.itstackdemodesign202.factory.JDKProxy;
import com.hehe.itstackdemodesign202.factory.impl.EGMCacheAdapter;
import com.hehe.itstackdemodesign202.factory.impl.IIRCacheAdapter;
import com.hehe.itstackdemodesign202.impl.CacheServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
@SpringBootTest
public class ApiTest {

    @Test
    public void test() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheService.class,new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","jilangf");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("测试结果：" + val01);


        CacheService proxy_IIR = JDKProxy.getProxy(CacheService.class,new IIRCacheAdapter());
        proxy_IIR.set("user_name_01","jilangf");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("测试结果：" + val02);
    }
}
