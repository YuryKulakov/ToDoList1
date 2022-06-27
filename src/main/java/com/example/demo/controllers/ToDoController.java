package com.example.demo.controllers;

import com.example.demo.domain.ToDoList;
import com.example.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    public ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("todo/create")
    public List<ToDoList> getAll() {
        return toDoService.getAll();
    }

    @GetMapping("todo/listTodoByUsername")
    public List<ToDoList> findTodoByUsername(@PathVariable String username) {
        return toDoService.getTodoForUser(username);
    }

    @GetMapping("todo/listTodoByTitle")
    public List<ToDoList> findTodoByTitle(@PathVariable String title) {
        return toDoService.getFindByTitle(title);
    }

    @PostMapping("todo/create")
    public ResponseEntity<ToDoList> create(@RequestBody ToDoList toDoList) {
        return ResponseEntity.ok(toDoService.create(toDoList));
    }

    @PutMapping("todo/{id}")
    public ResponseEntity<ToDoList> taskDone(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(toDoService.taskDone(id));
    }



}
