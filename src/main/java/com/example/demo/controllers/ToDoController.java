package com.example.demo.controllers;

import com.example.demo.domain.ToDoList;
import com.example.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public class ToDoController {
    public ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public List<ToDoList> getAll(){
        return toDoService.getAll();
    }


}
