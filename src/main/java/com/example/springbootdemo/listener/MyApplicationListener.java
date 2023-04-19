package com.example.springbootdemo.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener {

    public MyApplicationListener() {
        System.out.println("加载监听器");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听器监听到了" + event.getClass() + "事件");
    }
}
