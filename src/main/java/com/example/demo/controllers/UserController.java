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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    private String homePage(Model model) {
        model.addAttribute("title","Домашняя страница");
        return "home.html";
    }

    @GetMapping("/login")
    private String getCurrentUser() {
//        userService.getUser(user);
        return "login.html";
    }

    @GetMapping("/login/{username}/{password}")
    private boolean findUserByUsername(@PathVariable String username, @PathVariable String password) {
        System.out.println("GET User by username and password *****");
        return userService.getUserByUsername(username, password);
    }

    @PostMapping("/createuser")
    private boolean addUser(@RequestBody User user) {
        userService.saveUser(user);
        return true;
    }

}
