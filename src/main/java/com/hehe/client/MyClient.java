package com.hehe.client;

import com.dtflys.forest.annotation.DataParam;
import com.dtflys.forest.annotation.Request;

import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2020/07/26
 **/
public interface MyClient {
    @Request(url = "http://baidu.com")
    String simpleRequest();

    @Request(
            url = "http://baidu.com",
            dataType = "json"
    )
    Map getLocation(@DataParam("longitude") String longitude, @DataParam("latitude") String latitude);
}
