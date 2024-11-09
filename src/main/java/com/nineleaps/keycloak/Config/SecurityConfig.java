package com.nineleaps.keycloak.Config;

import com.nineleaps.keycloak.Converters.JwtAuthConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthConverter authConverter;

    @Autowired
    public SecurityConfig(JwtAuthConverter authConverter) {
        this.authConverter = authConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        http
                .oauth2ResourceServer(auth->auth.jwt(token->token.jwtAuthenticationConverter(authConverter)));
        http
                .sessionManagement(t->t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }

}
