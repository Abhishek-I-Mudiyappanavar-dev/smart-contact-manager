package com.scm.scm20.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig {

    // create user and login using java code with in memory service
    
    //user detail service object
    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailService);
    
        //password encoder object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());       

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}



// @Bean
    /* public UserDetailsService userDetailsService(){

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

    } */
