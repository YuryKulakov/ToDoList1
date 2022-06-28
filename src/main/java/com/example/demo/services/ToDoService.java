package com.example.demo.services;

import com.example.demo.domain.ToDoList;
import com.example.demo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoList> getAll() {
        return toDoRepository.findAll();
    }

    public ToDoList create(ToDoList toDoList) {
        toDoList.setDone(false);
        toDoList.setDateNow(Date.valueOf(LocalDate.now()));
        return toDoRepository.save(toDoList);

    }

    public ToDoList taskDone(Long toDoList) {
        Optional<ToDoList> optionalToDoList = toDoRepository.findById(toDoList);
        if(optionalToDoList.isPresent()){
            ToDoList toDoList1 = optionalToDoList.get();
            toDoList1.setDone(true);
            return toDoRepository.save(toDoList1);
        }
        return null;

    }

    public List<ToDoList> getFindByTitle(String titleSearch) {
        return toDoRepository.findByTitle(titleSearch);
    }

    public List<ToDoList> getTodoForUser(String username) {
        return toDoRepository.findAllByUsername(username);
    }



    public String delete(Long id) {
        toDoRepository.deleteById(id);
        return id+" task delete";
    }
}
