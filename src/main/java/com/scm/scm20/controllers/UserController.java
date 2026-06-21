package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    //user dashborad page

    @GetMapping("/dashboard")
    public String userDashboard(){
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    //user profile page

    @GetMapping("/profile")
    public String userProfile(){
        System.out.println("User profile");
        return "user/profile";
        
    };

    //user add contacts page

    //user view contacts

    //user edit contact

    //user delete contact

}
