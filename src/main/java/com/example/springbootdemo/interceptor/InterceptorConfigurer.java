package com.example.springbootdemo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Bean
    public MyInterceptor1 myInterceptor1() {
        return new MyInterceptor1();
    }

    @Bean
    public MyInterceptor2 myInterceptor2() {
        return new MyInterceptor2();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Order注解控制执行顺序，数字越小越靠前，否则按照注册顺序
        registry.addInterceptor(myInterceptor1()).addPathPatterns("/testTransaction").order(1);
        registry.addInterceptor(myInterceptor2()).addPathPatterns("/testTransaction").order(-1);
    }
}
