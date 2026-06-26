package com.scm.scm20.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;

import com.scm.scm20.repositories.UserRepo;
import com.scm.scm20.entities.User;

@Service
public class SecurityCustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
public UserDetails loadUserByUsername(String username) {

    System.out.println("Username received: " + username);

    User user = userRepo.findByEmail(username)
            .orElseThrow(() ->
                    new UsernameNotFoundException(username));

    System.out.println("User found: " + user.getEmail());

    return user;
}

}

/* 
 return userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with email "+username));
*/