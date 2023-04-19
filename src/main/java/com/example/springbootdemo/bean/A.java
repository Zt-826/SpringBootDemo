package com.example.springbootdemo.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

// @DependsOn设置了依赖关系，可以管理创建Bean的顺序
@DependsOn("b")
@Component
public class A implements InitializingBean {

    @Resource
    private B b;

    public A() {
        System.out.println("调用A的构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用A的afterPropertiesSet方法");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("调用A的postConstruct方法");
    }
}
