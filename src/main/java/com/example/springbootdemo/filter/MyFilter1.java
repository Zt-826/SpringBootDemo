package com.example.springbootdemo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Order(2)
//@Component
public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("调用MyFilter1");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
