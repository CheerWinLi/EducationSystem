package com.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .maxAge(168000)
                .allowedOriginPatterns("*")
                .allowedMethods("POST","GET","DELETE","OPTIONS","PUT")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
