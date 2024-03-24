package com.assessment.assessment.List.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.assessment.assessment.List.interceptors.LoggingInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    @SuppressWarnings("null")
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
    }
}