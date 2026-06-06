package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");
        model.addAttribute("name","Substring Tech");
        model.addAttribute("github","https://github.com/abhishek");
        model.addAttribute("leetCode","htts://leetcode.com/abhishek");
        return "home";
    }

    //about
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin",true);
        System.out.println("About page is loading");
        return "about";
    }

    //service
    @RequestMapping("/service")
    public String servicePage(){
        System.out.println("I can't be more spoon feeding now, you haven't built any shit yet");
        return "services";
    }

    //contact
    @RequestMapping("/contact")
    public String contactPage(){
        System.out.println("This is contact page");
        return "contact";
    }

    //login
    @RequestMapping("/login")
    public String loginPage(){
        System.out.println("This is login page");
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage(){
        System.out.println("This is signUp page");
        return "register";
    }
}
