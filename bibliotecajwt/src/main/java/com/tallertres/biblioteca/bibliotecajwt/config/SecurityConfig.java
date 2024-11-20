package com.tallertres.biblioteca.bibliotecajwt.config;

import com.tallertres.biblioteca.bibliotecajwt.utils.filters.JwtAuthenticationFilter;
import com.tallertres.biblioteca.bibliotecajwt.utils.filters.JwtAuthorizationFilter;
import com.tallertres.biblioteca.bibliotecajwt.utils.filters.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final UserDetailsService userDetailsService;


    // 1- Crear SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtUtils jwtUtils, AuthenticationManager manager) throws Exception{
        JwtAuthenticationFilter authenticationFilter = new JwtAuthenticationFilter(jwtUtils);
        authenticationFilter.setAuthenticationManager(manager);
        authenticationFilter.setFilterProcessesUrl("/login");

        return http
                //.authenticationManager(manager)
                //.authenticationProvider(authenticationProvider())
                .sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .csrf(c -> { c.disable(); })   /// Customizer.withDefaults()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/libro/create").hasRole("ADMIN");
                    auth.requestMatchers("/api/v1/libro/update").hasRole("ADMIN");
                    auth.requestMatchers("/api/v1/libro/delete").hasRole("ADMIN");    // .permiteAll()
                    auth.requestMatchers("/api/v1/libro/categoria").hasAnyRole("ADMIN","CLIENT");
                    auth.requestMatchers("/api/v1/libro/autor").hasAnyRole("ADMIN","CLIENT");
                    auth.requestMatchers("/api/v1/libro/prestamo").hasAnyRole("ADMIN","CLIENT");
                    //auth.requestMatchers("/login").permitAll();
                    auth.anyRequest().authenticated();
                })
                //.httpBasic(Customizer.withDefaults())
                .addFilter(authenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.withUsername("jccastillo")
                        .password(passwordEncoder().encode("12345"))
                        //.roles("ADMIN")
                        .authorities(new SimpleGrantedAuthority("ADMIN"))
                        .build()
        );
    }
    */


}
