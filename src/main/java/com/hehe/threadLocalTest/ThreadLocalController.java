package com.hehe.threadLocalTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘伟锋
 * @date 2020/09/17
 **/
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {
  @ResponseBody
  @RequestMapping("/test")
    public Long test(){
      return RequestHolder.getId();

    }
}
