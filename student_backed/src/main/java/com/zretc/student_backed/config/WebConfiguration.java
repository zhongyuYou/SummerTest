package com.zretc.student_backed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executors;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Value("${files.upload.fileMapper}")
    private String fileMapper;
    /**
     * 解决跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);
    }
    /**
     * 添加异步访问支持
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        /*2. 前端页面
        2.1. 定义chooseImage方法
        2.2. 定义上传图片到服务方法*/
        configurer.setTaskExecutor(new
                ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(3000);
    }
    /**
     * 静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileMapper+"**").addResourceLocations("file"+fileUploadPath);
    }
}

