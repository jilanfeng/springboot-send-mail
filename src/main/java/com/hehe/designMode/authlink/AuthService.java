package com.hehe.designMode.authlink;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author εδΌι
 * @date 2022/02/17
 **/
@Component
public class AuthService {


    /**
     * @param levelUserId
     * @param orderId
     * @return
     */
    public static Date queryAuthInfo(String levelUserId, String orderId) {
        return new Date();
    }

    public static void auth(String s, String s1) {
    }
}
