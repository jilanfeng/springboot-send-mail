package com.hehe.bankannation;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author 刘伟锋
 * @date 2021/10/05
 **/
@Slf4j
public class BankService {

    public static String createUser(String name, String identity, String mobile, int age) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        // 字符串靠左，多余的地方填充——
        stringBuilder.append(String.format("%-10s",name).replace(' ','_'));
        // 字符串靠左，多余的地方填充_
        stringBuilder.append(String.format("%-18s",identity).replace(' ','_'));
        //数字靠右，多余的地方用0填充
        stringBuilder.append(String.format("%5d",age));
        //数字靠右，多余的地方用0填充
        stringBuilder.append(String.format("%-11s",mobile).replace(' ','_'));
        //最后加上MD5作为签名
        stringBuilder.append(DigestUtils.md2Hex(stringBuilder.toString()));
        return Request.Post("http://localhost:45678/reflection/bank/createUser")
                .bodyString(stringBuilder.toString(), ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
    }
    //支付方法
    public static String pay(long userId, BigDecimal amount) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        //数字靠右，多余的地方用0填充
        stringBuilder.append(String.format("%20d",userId));
        //金额向下舍入2位到发呢，以分为单位，作为数字靠右，多余的地方用0填充
        stringBuilder.append(String.format("%010d",amount.setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue()));
        //最后加上Md5作为签名
        stringBuilder.append(DigestUtils.md2(stringBuilder.toString()));
        return Request.Post("http://localhost:45678/reflection/bank/pay").bodyString(stringBuilder.toString(),ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();

    }


    public static String remoteCall(AbstractAPI api) throws IOException {
        // 从BankAPI注解获取请求地址
        BankAPI backAPI = api.getClass().getAnnotation(BankAPI.class);
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(api.getClass().getDeclaredFields())    // 获取所有字段
                .filter(field -> field.isAnnotationPresent(BankAPIField.class))  // 查找标记了注解的字段
                .sorted(Comparator.comparingInt(a -> a.getAnnotation(BankAPIField.class).order())) //根据注解中的order 对字段排序
                .peek(field -> field.setAccessible(true))  //设置可以访问私有字段
                .forEach(field -> {BankAPIField bankAPIField = field.getAnnotation(BankAPIField.class);  //获得驻俄籍
            Object value = "";
            try {
                // 反射获取字段值
                value = field.get(api);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            stringBuilder.append(bankAPIField.type().format(value,bankAPIField));
        });
        // 签名逻辑
        stringBuilder.append(DigestUtils.md2Hex(stringBuilder.toString()));
        String param = stringBuilder.toString();
        long begin= System.currentTimeMillis();
        //发请求
        String result = Request.Post("http://localhost:45678/reflection" + backAPI.url())
                .bodyString(param,ContentType.APPLICATION_JSON).execute().returnContent().asString();
        log.info("调用银行API {}，url:{},参数:{},耗时：{} ms",backAPI.desc(),backAPI.url(),param,System.currentTimeMillis() - begin);
        return result;

    }


    public static String createUser1(String name,String identity,String mobile,int age) throws IOException {
        CreateUserAPI createUserAPI = new CreateUserAPI();
        createUserAPI.setName(name);
        createUserAPI.setIdentity(identity);
        createUserAPI.setAge(age);
        createUserAPI.setMobile(mobile);
        return remoteCall(createUserAPI);
    }
  public static String Pay(long userId,BigDecimal amount) throws IOException {
      PayAPI payAPI = new PayAPI();
      payAPI.setUserId(userId);
      payAPI.setAmount(amount);
      return remoteCall(payAPI);
  }





}


