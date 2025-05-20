package com.jonatan.gestao_hospitalar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa proteção CSRF (usada em formulários)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // permite todas as requisições
                )
                .httpBasic(Customizer.withDefaults()); // desativa autenticação básica

        return http.build();
    }
}
