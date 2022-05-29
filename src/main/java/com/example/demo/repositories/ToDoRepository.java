package com.example.demo.repositories;

import com.example.demo.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoList, Long> {

    List<ToDoList> findByTitle(String titleSearch);

    List<ToDoList> findAllByUsername(String username);

}
