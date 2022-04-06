package com.hehe;

import com.alibaba.fastjson.JSON;
import com.hehe.client.MyClient;
import com.hehe.threadLocalTest.HttpFilter;
import com.hehe.threadLocalTest.HttpInterceptor;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootApplication
@ForestScan(basePackages = "com.hehe.client")
public class HeheApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(HeheApplication.class, args);
        System.out.println("HeheApplication started!");
    }

    @Resource
    private MyClient myClient;

    public void yourMethod() throws Exception {

        Map result = myClient.getLocation("124.730329", "31.463683");
        System.out.println(JSON.toJSONString(result,true));
    }

    @Bean
    public FilterRegistrationBean httpFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new HttpFilter());
        registrationBean.addUrlPatterns("/threadLocal/*");
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }



}
