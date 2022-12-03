package com.example.hwspringbuytickets.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LayoutConfig {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
