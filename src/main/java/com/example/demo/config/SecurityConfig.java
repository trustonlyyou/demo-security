package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/").permitAll() // 모든 사용자(인증 여부와 상관없이)가 이 URL 에 접근할 수 있도록 허용
                .anyRequest().authenticated() // 나머지 모든 요청은 인증된 사용자만 접근할 수 있도록 설정
        );

        return http.build();
    }
}
