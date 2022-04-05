package com.hehe.yanshi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ThreadLocal 造成内存泄露
 *
 * @author 刘伟锋
 * @date 2021/05/08
 **/
public class LeakingServlet extends HttpServlet {
    private static MyThreadLocal myThreadLocal = new MyThreadLocal();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyCounter counter = myThreadLocal.get();
        if(counter == null) {

            counter = new MyCounter();
            myThreadLocal.set(counter);
        }
        resp.getWriter().println(
                "The current thread served this servlet" + counter.getCount() + "times"
        );
        counter.increment();
    }
}
