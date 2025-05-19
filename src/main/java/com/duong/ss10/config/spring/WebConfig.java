package com.duong.ss10.config.spring;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(
                        null,     // upload directory (null = dùng tạm mặc định)
                        52428800, // maxFileSize = 50MB
                        52428800, // maxRequestSize = 50MB
                        0         // fileSizeThreshold
                );
        registration.setMultipartConfig(multipartConfigElement);
    }
}
