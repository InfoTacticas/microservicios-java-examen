package com.newhorizons.takeitnow.kardex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean("restTemplateClient")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
