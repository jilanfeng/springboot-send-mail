package com.hehe.yanshi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 一個綫程OOM，其他綫程還能運行嗎
 *
 * @author 刘伟锋
 * @date 2021/05/03
 **/
public class JvmThread {
    public static void main(String[] args) {
        new Thread(() -> {
            List<byte[]> list = new ArrayList<byte[]>();
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                byte[] b = new byte[1024 * 1024 * 1];
                list.add(b);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {

            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
