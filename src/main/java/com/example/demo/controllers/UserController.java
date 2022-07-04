package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    private String homePage(Model model) {
//        model.addAttribute("title","Домашняя страница");
//        return "home.html";
//    }

    @GetMapping("/")
    private String getCurrentUser() {
//        userService.getUser(user);
        return "login.html";
    }

    @GetMapping("/registration")
    private String registrationPage() {
        return "registration.html";
    }


    @PostMapping (value = "/registration")
    public String registrationUser(@ModelAttribute User user) {
        if( userService.chekPasAndLog(user.getUsername(),user.getPassword())) {
            userService.saveUser(user);
        }else{
            return "registration.html";
        }
        return "redirect:/login";
    }



}
