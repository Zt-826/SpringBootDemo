package com.example.springbootdemo.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class B implements InitializingBean {

    // 懒加载解决循环依赖
    @Lazy
    @Resource
    private A a;

    public B() {
        System.out.println("调用B的构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用B的afterPropertiesSet方法");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("调用B的postConstruct方法");
    }
}
