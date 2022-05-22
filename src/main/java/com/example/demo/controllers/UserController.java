package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    private boolean addUser(@RequestBody User user) {
        boolean userExits = userService.findUserByUsername(user.getUserName());
        if (userExits) {
            System.out.println("A user with this name exists, please select a different name.");
            return false;
        }
        userService.saveUser(user);
        return true;
    }

}
