package com.example.springbootdemo.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationContexts implements ApplicationContextAware, InitializingBean {

    public ApplicationContexts() {
        System.out.println("调用ApplicationContexts的构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用ApplicationContexts的afterPropertiesSet方法");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("调用ApplicationContexts的postConstruct方法");
    }


    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用setApplicationContext方法");
        ApplicationContexts.applicationContext = applicationContext;
    }

    /**
     * 获取上下文
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取Bean
     *
     * @param beanName beanName
     * @return Object
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /**
     * 获取Bean
     *
     * @param clazz clazz
     * @return T
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 获取Bean
     *
     * @param beanName beanName
     * @param clazz    clazz
     * @return T
     */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return applicationContext.getBean(beanName, clazz);
    }
}
