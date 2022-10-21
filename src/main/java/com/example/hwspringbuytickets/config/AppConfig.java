package com.example.hwspringbuytickets.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper appModelMapper()
    {
        return new ModelMapper();
    }
}
