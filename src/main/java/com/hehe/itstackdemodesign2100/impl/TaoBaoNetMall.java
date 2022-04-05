package com.hehe.itstackdemodesign2100.impl;

import com.alibaba.fastjson.JSON;
import com.hehe.itstackdemodesign2100.HttpClient;
import com.hehe.itstackdemodesign2100.NetMall;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class TaoBaoNetMall extends NetMall {
    public TaoBaoNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected boolean login(String uId, String uPwd) {
        logger.info("模拟淘宝用户登录 uId:{} uPwd:{}",uId,uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skyUrl) {
        String str = HttpClient.doGet(skyUrl);
        Pattern p = Pattern.compile("(?<=titile\\>).*(?=</title)");
        Matcher matcher = p.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String,String>();
        if (matcher.find()) {
            map.put("name",matcher.group());
        }
        map.put("price","4799.00");
        logger.info("模拟淘宝商品爬虫解析:{} | {} 元 {}",map.get("name"),map.get("price"),skyUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟生成淘宝商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());      }
}
