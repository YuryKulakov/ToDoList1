package com.example.demo.controllers;

import com.example.demo.domain.ToDoList;
import com.example.demo.domain.User;
import com.example.demo.services.ToDoService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ToDoService toDoService;

    @PostMapping("/createuser")
    private void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PostMapping("/create")
    public ResponseEntity<ToDoList> create(@RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoService.create(toDoList));
    }
}

