package com.scm.scm20.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;


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
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //configuration
        // Configure public and protected URL access rules
        httpSecurity.authorizeHttpRequests(authorize->{

            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();

            // authorize.requestMatchers("/home","/css/**","/js/**","/images/**","/favicon.ico").permitAll();
            // authorize.requestMatchers("/login","/register").permitAll();
        });

        //form default login
        //if we want to change anything about form login check here: form login related
        httpSecurity.formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    };

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
