package com.example.PointofSale.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper ModelMapperConfig() {
        return new ModelMapper();
    }
}
