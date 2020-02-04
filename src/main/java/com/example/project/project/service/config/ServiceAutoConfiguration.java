package com.example.project.project.service.config;

import com.example.project.project.service.CarShopService;
import com.example.project.project.service.FakeCarShopService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAutoConfiguration {

    @Bean
    public FakeCarShopService carShopServices() {
        return new CarShopService();
    }
}
