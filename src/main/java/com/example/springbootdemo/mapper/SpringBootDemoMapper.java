package com.example.springbootdemo.mapper;

import com.example.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper
public interface SpringBootDemoMapper {
    void addUser(@Param("user") User user);

    void insertLog(@Param("user") User user, @Param("currentTimeMillis") long currentTimeMillis,
                   @Param("date") LocalDate date, @Param("timestamp") LocalDateTime timestamp);

    void getUser(@Param("id") String id);
}
