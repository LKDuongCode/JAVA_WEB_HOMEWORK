package com.duong.ss10.config.spring;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.duong.ss10.config.cloudinary.CloudinaryLoadProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {BasePackages.controller, BasePackages.repository, BasePackages.service, BasePackages.cloudinary}
)
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver (){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }



    @Bean
    public Cloudinary cloudinary() {

        Properties props = CloudinaryLoadProperties.load();
        if (props == null) {
            throw new RuntimeException("Không thể load file cấu hình Cloudinary");
        }

        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", props.getProperty("cloudinary.cloud_name"),
                "api_key", props.getProperty("cloudinary.api_key"),
                "api_secret", props.getProperty("cloudinary.api_secret"),
                "secure", true
        ));
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/css/**")
//                .addResourceLocations("/WEB-INF/css/");
//
//        registry.addResourceHandler("/js/**")
//                .addResourceLocations("/WEB-INF/js/");

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("/uploads/");
    }


}
