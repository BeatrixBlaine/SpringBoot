package com.mavenproject.springboot.demo.mycoolapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // create users for api security
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

    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // JDBC Authentication - users stored in the database
    @Bean
    public UserDetailsManager users(DataSource dataSource) {

        // for custom tables schema
        /*
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        theUserDetailsManager
                .setUsersByUsernameQuery("select username, password, active from users where username=?");

        theUserDetailsManager
                .setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        */

        return new JdbcUserDetailsManager(dataSource);
    }

    // disable csrf
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Manage authorized user for HttpMethod
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Employee Page & Owner Page
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/owner/**").hasRole("OWNER")
                        .requestMatchers("/employees/add-employee").hasRole("MANAGER")
                        .requestMatchers("/employees/update-employee").hasRole("MANAGER")
                        .requestMatchers("/employees/delete").hasRole("MANAGER")

                        // PRIVATE
                        // Employees API
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE","OWNER","MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE","OWNER","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees/**").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAnyRole("OWNER","MANAGER")

                        // Staff API
                        .requestMatchers(HttpMethod.GET, "/api/staffs").hasAnyRole("EMPLOYEE","OWNER","MANAGER")
                        .requestMatchers(HttpMethod.GET, "/api/staffs/**").hasAnyRole("EMPLOYEE","OWNER","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/staffs").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/staffs/**").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/staffs").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "/api/staffs/**").hasAnyRole("OWNER","MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/staffs/**").hasAnyRole("OWNER","MANAGER")

                        .anyRequest().authenticated()

        ).formLogin(form ->
                form
                        .loginPage("/login-page")
                        .loginProcessingUrl("/authenticateTheUser")
                        .successHandler((request, response, authentication) -> {

                            if (authentication.getAuthorities().stream()
                                    .anyMatch(a -> a.getAuthority().equals("ROLE_OWNER"))) {

                                response.sendRedirect("/owner/index");

                            } else {

                                response.sendRedirect("/employees/list");
                            }
                        })
                        .permitAll()
        ).logout(logout ->
                logout.permitAll()
        ).exceptionHandling(configurer ->
                configurer.accessDeniedPage("/access-denied")
        );

        // Use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross-Site Request Forgery
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
