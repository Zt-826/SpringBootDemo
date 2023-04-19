package com.example.springbootdemo.processor;

import com.example.springbootdemo.aware.ApplicationContexts;
import com.example.springbootdemo.bean.A;
import com.example.springbootdemo.bean.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass == A.class || beanClass == B.class || beanClass == ApplicationContexts.class) {
            System.out.println("调用" + beanName + "的实例化前置处理方法");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof A || bean instanceof B || bean instanceof ApplicationContexts) {
            System.out.println("调用" + beanName + "的实例化后置处理方法");
        }
        return true;
    }

    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (bean instanceof A || bean instanceof B || bean instanceof ApplicationContexts) {
            System.out.println("调用" + beanName + "的属性处理方法");
        }
        return null;
    }
}
