package com.hzy.demo.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/*@Component*/
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行--MyFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行--servletRequest");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("执行--destroy");
    }
}
