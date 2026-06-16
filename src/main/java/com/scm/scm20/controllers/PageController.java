package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.services.UserService;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");
        model.addAttribute("name","Substring Tech");
        model.addAttribute("github","https://github.com/abhishek");
        model.addAttribute("leetCode","htts://leetcode.com/abhishek");
        return "home";
    }

    //about
    @GetMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin",true);
        System.out.println("About page is loading");
        return "about";
    }

    //service
    @GetMapping("/service")
    public String servicePage(){
        System.out.println("I can't be more spoon feeding now, you haven't built any shit yet");
        return "services";
    }

    //contact
    @GetMapping("/contact")
    public String contactPage(){
        System.out.println("This is contact page");
        return "contact";
    }

    //login
    @GetMapping("/login")
    public String loginPage(){
        System.out.println("This is login page");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        System.out.println("This is signUp page");

        UserForm userForm = new UserForm();
        //default data can be filled
        // userForm.setName("Abhishek");
        model.addAttribute("userForm",userForm);

        return "register";
    }

    @PostMapping(value="/do-register")
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Processing Registration");
        //fetch form data
        //UserForm
        System.out.println(userForm);

        // TODO: validate form data

        //save to database

        // userservice

        User user = User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("data:image/jpeg;base64,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")
        .build();
        User savedUser = userService.saveUser(user);
        System.out.println("User saved");

        //message = "Registration Successful"
        //redirect to login page
        return "redirect:/register";
    }
}
