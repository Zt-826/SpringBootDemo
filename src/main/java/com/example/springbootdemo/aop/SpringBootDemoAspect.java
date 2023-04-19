package com.example.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringBootDemoAspect {

    /**
     * execution (* com.example.springbootdemo.service..*.*(..))
     * <p>
     * execution()：表达式主体
     * 第一个*号：表示返回类型，*号表示所有的类型
     * 包名：表示需要拦截的包名，后面的两个句点分别表示当前包和当前包的所有子包
     * 第二个*号：表示类名，*号表示所有的类
     * *(..) ：第三个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(public * com.example.springbootdemo.service.SpringBootDemoService.testAopByFunction(..))")
    public void pointCutByFunction() {
    }

//    @Pointcut("@annotation(com.example.springbootdemo.aop.AopAnnotation)")
//    public void pointCutByAnnotation() {
//
//    }

    @Around("pointCutByFunction() || @annotation(AopAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("调用Around方法的前半段");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("调用Around方法的后半段");
        return proceed;
    }

    @Before("pointCutByFunction()")
    public void before() {
        System.out.println("调用before方法");
    }

    @After("pointCutByFunction()")
    public void after() {
        System.out.println("调用after方法");
    }
}
