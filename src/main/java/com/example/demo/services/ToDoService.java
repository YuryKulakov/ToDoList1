package com.example.demo.services;

import com.example.demo.domain.ToDoList;
import com.example.demo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
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
        toDoList.setDone(false);
        toDoList.setDateNow(Date.valueOf(LocalDate.now()));
        return toDoRepository.save(toDoList);

    }

    List <ToDoList> findByTitle(ToDoList toDoList){
        return
    }

    public void delete(Long id){
        toDoRepository.deleteById(id);
    }
}
