package com.bjut.community.config;

import com.bjut.community.controller.interceptor.LoginRequiredInterceptor;
import com.bjut.community.controller.interceptor.LoginTicketInterceptor;
import com.bjut.community.controller.interceptor.MessageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;
    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;
    @Autowired
    private MessageInterceptor messageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.jpg", "/*/*.png", "/*/*.jpeg");
        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.jpg", "/*/*.png", "/*/*.jpeg");
        registry.addInterceptor(messageInterceptor)
                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.jpg", "/*/*.png", "/*/*.jpeg");
    }

}
