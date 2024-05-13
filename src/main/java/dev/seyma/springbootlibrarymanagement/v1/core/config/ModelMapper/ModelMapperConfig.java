package dev.seyma.springbootlibrarymanagement.v1.core.config.ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    public ModelMapper getModelMapper() {
        @Bean
        return new ModelMapper();
    }
}
