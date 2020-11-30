package com.tp.album_manager.web.config;

import com.tp.album_manager.web.interceptor.AlbumInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AlbumInterceptor albumInterceptor;

    @Autowired
    public WebMvcConfig(AlbumInterceptor albumInterceptor) {
        this.albumInterceptor = albumInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(albumInterceptor).addPathPatterns("/Albums");
        registry.addInterceptor(albumInterceptor).addPathPatterns("/Albums/{id}");
    }
}
