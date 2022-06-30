package com.example.demo.controllers;

import com.example.demo.domain.ToDoList;
import com.example.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {
    public ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/tasks")
    public List<ToDoList> getAll() {
        return toDoService.getAll();
    }

    @GetMapping("/")
    private String homePage(Model model) {
        model.addAttribute("title","Домашняя страница");
        model.addAttribute("todo",toDoService.getAll());
        return "home.html";
    }

    @GetMapping("/listtodobyusername")
    public List<ToDoList> findTodoByUsername(@PathVariable String username) {
        return toDoService.getTodoForUser(username);
    }

    @GetMapping("/listtodobytitle")
    public List<ToDoList> findTodoByTitle(@PathVariable String title) {
        return toDoService.getFindByTitle(title);
    }

//    @PostMapping("/create")
//    public ResponseEntity<ToDoList> create(@RequestBody ToDoList toDoList) {
//        return ResponseEntity.ok(toDoService.create(toDoList));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> taskDone(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(toDoService.taskDone(id));
    }

    @DeleteMapping("/delete/{id}")
    public  String deleteTask(@PathVariable(value = "id") Long id){
        return toDoService.delete(id);

    }



}
