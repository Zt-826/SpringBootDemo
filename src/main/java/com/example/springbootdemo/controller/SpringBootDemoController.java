package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.service.SpringBootDemoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SpringBootDemoController {
    @Resource
    private SpringBootDemoService springBootDemoService;

    @RequestMapping("/testTransaction")
    public int testTransaction(@RequestBody User user) {
        return springBootDemoService.testTransaction(user);
    }

    @RequestMapping("/testAopByFunction")
    public void testAopByFunction() {
        springBootDemoService.testAopByFunction();
    }

    @RequestMapping("/testAopByAnnotation")
    public void testAop() {
        springBootDemoService.testAopByAnnotation();
    }
}
