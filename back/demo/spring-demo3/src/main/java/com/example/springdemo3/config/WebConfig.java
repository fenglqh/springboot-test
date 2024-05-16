package com.example.springdemo3.config;

import com.example.springdemo3.intercept.LoginIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 配置拦截器
    @Autowired
    private LoginIntercept loginIntercept; // 创建被管理对象的类也要交给spring管理
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
//        registry.addInterceptor(new LoginIntercept()); 可以自己new 也可以交给spring进行创建
        registry.addInterceptor(loginIntercept).addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/pic/**")
                .excludePathPatterns("/**/*.html") ;// 拦截的路径 按照映射的路由进行排除，而不是按照文件夹


    }
}
