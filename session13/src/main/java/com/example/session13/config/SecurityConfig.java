package com.example.session13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)

                // 🔹 Cấu hình quyền truy cập
                .authorizeHttpRequests(auth -> auth
                        // cho phép tất cả truy cập endpoint auth
                        .requestMatchers("/api/v1/auth/**").permitAll()

                        // tất cả request còn lại phải đăng nhập
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}