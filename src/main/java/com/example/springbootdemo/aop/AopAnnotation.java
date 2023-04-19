package com.example.springbootdemo.aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopAnnotation {
    boolean enable() default true;
}
