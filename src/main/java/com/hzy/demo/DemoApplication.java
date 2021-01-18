package com.hzy.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@SpringBootApplication
@MapperScan("com.hzy.demo.mapper")
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        Long time=System.currentTimeMillis();
        SpringApplication.run(MySpringbootTomcatStarter.class);
        System.out.println("===应用启动耗时："+(System.currentTimeMillis()-time)+"===");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());

    }
}
