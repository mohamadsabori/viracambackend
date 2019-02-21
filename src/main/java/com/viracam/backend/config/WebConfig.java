package com.viracam.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Mohammad on 1/8/2018.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS").allowedOrigins("*").allowedHeaders("Access-Control-Allow-Origin");
//        registry.addMapping("/product/loadAllProducts").allowedOrigins("http://localhost:4200").allowedHeaders("Access-Control-Allow-Origin");
//        registry.addMapping("/product/add").allowedOrigins("http://localhost:4200").allowedHeaders("Access-Control-Allow-Origin");
    }
}
