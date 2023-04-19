package com.example.springbootdemo.processor;

import com.example.springbootdemo.aware.ApplicationContexts;
import com.example.springbootdemo.bean.A;
import com.example.springbootdemo.bean.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof A || bean instanceof B || bean instanceof ApplicationContexts) {
            System.out.println("调用" + beanName + "的初始化前置处理方法");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof A || bean instanceof B || bean instanceof ApplicationContexts) {
            System.out.println("调用" + beanName + "的初始化后置处理方法");
        }
        return bean;
    }
}
