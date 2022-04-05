package com.hehe.designMode.adapter;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * MQ消息体适配类
 * 这个类里的方法非常重要，主要用于把不同类型MQ种的各种属性，映射成我们需要的属性返回。就像一个属性中用户ID;uID，映射成我们需要的的userId
 * 做统一处理。
 * <p>
 * 而在这个处理过程中需要把映射管理传递Map<String,String> link,也就是准确的描述了，当前MQ中某个属性名称，映射成我们的某个属性名称。
 * 最终因为我们接收到的MQ消息基本都是json格式，可以转换为Map结构。最后使用反射调用的方式给我们的类型赋值
 *
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class MQAdapter {

    public static RebateInfo filter(String strJson, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(strJson, Map.class), link);
    }


    public static RebateInfo filter(Map obj, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(key);
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(rebateInfo, val.toString());
        }
        return rebateInfo;
    }
}
