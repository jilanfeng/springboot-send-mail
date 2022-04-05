package com.hehe.yanshi;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示查看對象個數   堆轉儲 dump
 *
 * @author 刘伟锋
 * @date 2021/05/03
 **/
public class Demo1_13 {
    public static void main(String[] args) throws InterruptedException {
        List<User> users = new ArrayList();
        for (int i = 0;
             i < 200;
             i++) {
            users.add(new User());

        }
        Thread.sleep(1000000000L);
    }

    static class User {
        private byte[] big = new byte[1024*1024];
    }
}
