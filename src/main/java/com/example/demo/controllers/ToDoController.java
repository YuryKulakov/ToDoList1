package com.example.demo.controllers;

import com.example.demo.domain.ToDoList;
import com.example.demo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @GetMapping("/home")
    private String homePage(Model model) {
        model.addAttribute("title","Домашняя страница");
        model.addAttribute("todo",toDoService.getAll());
        return "home.html";
    }

    @GetMapping("/create")
    private String createPage(Model model) {
        model.addAttribute("title","Создание");
        model.addAttribute("todo",toDoService.getAll());
        return "create.html";
    }

    @GetMapping("/createnewtask")
    private String create(Model model) {
        model.addAttribute("todolist");
        return "createnewtask.html";
    }

    @PostMapping("/createnewtask")
    private String createTask(ToDoList toDoList,Principal principal) {
        toDoList.setUsername(principal.getName());
        toDoService.create(toDoList);
        return "createnewtask.html";
    }

    @GetMapping("/alltasks")
    private String allTasksPage(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("todo",toDoService.getTodoForUser(username));
        //toDoService.create(toDoList);
        return "alltasks.html";
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

//    @PutMapping("/{id}")
//    public ResponseEntity<ToDoList> newTask(@PathVariable(name = "id") Long id) {
//        toDoService.create(toDoList);
//        return ResponseEntity.ok(toDoService.taskDone(id));
//    }

    @GetMapping("/{id}")
    public String taskDone(@PathVariable(name = "id") Long id) {
        toDoService.taskDone(id);
        return "redirect:/alltasks";
    }

    @DeleteMapping("/delete/{id}")
    public  String deleteTask(@PathVariable(value = "id") Long id){
        return toDoService.delete(id);

    }



}
