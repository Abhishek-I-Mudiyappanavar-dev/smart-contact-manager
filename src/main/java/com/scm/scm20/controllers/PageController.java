package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.helpers.Message;
import com.scm.scm20.helpers.MessageType;
import com.scm.scm20.services.UserService;

import jakarta.servlet.http.HttpSession;


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
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){
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
        .profilePic("D:/downloads/profilePic.jpg")
        .build();

        User savedUser = userService.saveUser(user);
        System.out.println("User saved");

        //message = "Registration Successful"
        //add message

        Message message = Message.builder().content("Registration Successful").type(MessageType.blue).build();
        session.setAttribute("message",message);

        //redirect to login page
        return "redirect:/register";
    }
}

