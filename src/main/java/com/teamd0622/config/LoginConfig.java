package com.teamd0622.config;

import com.teamd0622.interception.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns( //添加不拦截路径
                //登录路径
                "/login",
                "/register",
                "/**/*.js",
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.css"
        ).excludePathPatterns("/swagger-resources/**", "/swagger-ui.html/**", "/v2/**", "/webjars/**"); // 排除Swagger的请求
    }

}
