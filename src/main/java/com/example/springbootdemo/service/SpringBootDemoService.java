package com.example.springbootdemo.service;

import com.example.springbootdemo.aop.AopAnnotation;
import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.mapper.SpringBootDemoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SpringBootDemoService {

    @Resource
    private SpringBootDemoMapper mapper;

    @Resource
    private TestTransactionService testTransactionService;

    @Transactional(rollbackFor = Exception.class)
    public int testTransaction(User user) {
        mapper.addUser(user);
        return testTransactionService.saveLogWithRequired(user);
//        return testTransactionService.saveLogWithSupports(user);
//        return testTransactionService.saveLogWithMandatory(user);
//        return testTransactionService.saveLogWithRequiresNew(user);
//        return testTransactionService.saveLogWithMandatory(user);
//        return testTransactionService.saveLogWithRequiresNew(user);
//        return testTransactionService.saveLogWithNotSupported(user);
//        return testTransactionService.saveLogWithNever(user);
//        return testTransactionService.saveLogWithNested(user);
    }

    public void testAopByFunction() {
        System.out.println("调用testAopByFunction");
    }

    @AopAnnotation()
    public void testAopByAnnotation() {
        System.out.println("调用testAopByAnnotation");
    }
}
