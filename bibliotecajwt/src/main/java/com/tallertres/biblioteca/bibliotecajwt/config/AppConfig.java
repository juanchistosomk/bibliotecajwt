package com.tallertres.biblioteca.bibliotecajwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){   // Para realizar solicitudes HTTP a servicios web RESTful
        return new RestTemplate();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.withUsername("jccastillo")
                        .password(new BCryptPasswordEncoder().encode("12345"))
                        .authorities(new SimpleGrantedAuthority("ADMIN"))
                        .build()
        );
    }


}
