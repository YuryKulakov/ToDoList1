package com.example.demo.services;

import com.example.demo.domain.ToDoList;
import com.example.demo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoList> getAll(){
        return toDoRepository.findAll();
    }

    public ToDoList create(ToDoList toDoList){
        return toDoRepository.save(toDoList);
    }

    public void delete(Long id){
        toDoRepository.deleteById(id);
    }
}
