package com.hzy.demo.config;

import com.hzy.demo.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/*@Configuration*/
public class InterceptorConfig extends WebMvcConfigurationSupport {



    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/xx");
        super.addInterceptors(registry);*/
    }
}
