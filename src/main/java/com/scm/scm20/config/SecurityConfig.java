package com.scm.scm20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig {

    // create user and login using java code with in memory service
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User
        .withUsername("admin123")
        .password("{noop}admin@123")
        .roles("ADMIN","USER")
        .build();

        UserDetails user2 = User
        .withUsername("user123")
        .password("{noop}user@123")
        .build();

        var inMemoryUserDetailsManager =new InMemoryUserDetailsManager(user1,user2);
        return inMemoryUserDetailsManager;

    }

}
