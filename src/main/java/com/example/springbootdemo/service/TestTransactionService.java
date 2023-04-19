package com.example.springbootdemo.service;

import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.mapper.SpringBootDemoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TestTransactionService {

    @Resource
    private SpringBootDemoMapper mapper;

    // Propagation.REQUIRED：如果当前存在事务，那么就加入这个事务，不存在就新建一个事务。
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int saveLogWithRequired(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }

    // Propagation.SUPPORTS：如果当前存在事务，那么就加入这个事务，不存在就以无事务运行。
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public int saveLogWithSupports(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }

    // Propagation.MANDATORY：如果当前存在事务，那么就加入这个事务，不存在就抛异常。
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public int saveLogWithMandatory(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }

    // Propagation.REQUIRES_NEW：无论外部调用是否存在事务，都创建一个新的事务，两个事务互不干扰。
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int saveLogWithRequiresNew(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }

    // Propagation.NOT_SUPPORTED：不支持事务，即以非事务的方式运行
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public int saveLogWithNotSupported(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }

    // Propagation.NEVER：不能存在事务，以非事务的方式运行，如果外部存在事务，则抛出异常
    @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public int saveLogWithNever(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }

    // Propagation.NESTED：嵌套事务，如果当前调用方法存在一个事务，则会创建一个新的事务当作当前事务的嵌套事务来运行，如果当前不存在事务，则该机制与Propagation.REQUIRED机制一样
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public int saveLogWithNested(User user) {
        long currentTimeMillis = System.currentTimeMillis();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        mapper.insertLog(user, currentTimeMillis, date, localDateTime);
        return 10 / 0;
    }
}
