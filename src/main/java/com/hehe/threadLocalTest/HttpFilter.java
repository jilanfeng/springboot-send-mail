package com.hehe.threadLocalTest;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author 刘伟锋
 * @date 2020/09/17
 **/
@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter,{},{}",Thread.currentThread().getId(),request.getServletPath());
       //在ThreadLocal中添加当前线程ID
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
