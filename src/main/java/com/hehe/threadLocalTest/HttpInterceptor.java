package com.hehe.threadLocalTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 刘伟锋
 * @date 2020/09/17
 **/

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("ThreadId:"+RequestHolder.getId());
        RequestHolder.remove();
        log.info("afterCompletion");
        return;
    }

}
