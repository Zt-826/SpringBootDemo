package com.example.springbootdemo.spi;

public class MyAutoConfiguration {
    public MyAutoConfiguration() {
        System.out.println("通过spi方式，自动装配" + this.getClass());
    }
}
