package com.mavenproject.springboot.demo.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // create users for api secutiry
    /* @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails cita = User.builder()
                .username("cita")
                .password("{noop}12345")
                .roles("EMPLOYEE")
                .build();

        UserDetails addina = User.builder()
                .username("addina")
                .password("{noop}12345")
                .roles("OWNER")
                .build();

        UserDetails icad = User.builder()
                .username("icad")
                .password("{noop}12345")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(cita, addina, icad);

    } */

    // JDBC Authentication - users stored in the database
    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    // disable csrf
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Manage authorized user for HttpMethod
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE","OWNER","MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE","OWNER","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees/**").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAnyRole("OWNER","MANAGER")

                        // Enabling accessing all endpoints
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
        );

        // Use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross-Site Request Forgery
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
