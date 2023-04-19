package com.example.springbootdemo.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyInitializer implements ApplicationContextInitializer {
    public MyInitializer() {
        System.out.println("加载初始化器");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("执行初始化器" + applicationContext.getClass());
    }
}
