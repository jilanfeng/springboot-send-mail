package com.hehe.itstackdemodesign2100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 刘伟锋
 * @date 2021/12/19
 **/
public class HttpClient {
    public static String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        //返回结果字符串
        String result = null;

        try {
            //创建远程url连接对象
            URL url = new URL(httpurl);
            //通过远程URL连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection)url.openConnection();
            //设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            //发送请求
            connection.connect();
            // 通过connection连接，获取輸入流
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                //封装输入流is,并指定字符集
                br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                //存放数据
                StringBuilder sbr = new StringBuilder();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbr.append(temp);
                    sbr.append("\r\n");
                }
                result = sbr.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            assert connection != null;
            //关闭远程连接
            connection.disconnect();
        }
        return result;
    }
}
