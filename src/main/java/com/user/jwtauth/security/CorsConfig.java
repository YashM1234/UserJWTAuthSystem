package com.user.jwtauth.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from these origins (you can set specific origins)
        config.setAllowedOrigins(List.of("http://localhost:4200"));

        // Allow specific HTTP methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));

        // Allow specific headers
        config.setAllowedHeaders(List.of("*"));

        // Allow credentials (e.g., cookies)
        config.setAllowCredentials(true);

        // Expose specific headers in response
        config.setExposedHeaders(List.of("Authorization"));

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
