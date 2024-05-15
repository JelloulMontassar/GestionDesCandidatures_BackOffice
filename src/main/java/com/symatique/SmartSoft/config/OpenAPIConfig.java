package com.symatique.SmartSoft.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("public-api")
            .packagesToScan("com.symatique.SmartSoft.controllers") 
            .build();
    }
}
