package com.tallertres.biblioteca.bibliotecajwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){   // Para realizar solicitudes HTTP a servicios web RESTful
        return new RestTemplate();
    }

}
