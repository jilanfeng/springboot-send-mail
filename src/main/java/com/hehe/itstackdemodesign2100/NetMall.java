package com.hehe.itstackdemodesign2100;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public abstract class NetMall {
    public Logger logger = LoggerFactory.getLogger(NetMall.class);

    /**
     * 用户ID
     */
    String uId;

    /**
     * 用户密码
     */
    String uPwd;

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }


    public String generateGoodsPoster(String skyUrl) {
        //1.验证登录
        if (!login(uId,uPwd))  return null;
        //2.爬虫海报
        Map<String,String> reptile = reptile(skyUrl);
        //3.组装海报
        return createBase64(reptile);

    }

    // 模拟登录
    protected abstract boolean login(String uId, String uPwd);

    //爬虫提取商品信息（登陆后的优惠价格）
    protected abstract Map<String,String> reptile(String skyUrl);

    //生成海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);
}
