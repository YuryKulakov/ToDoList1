package com.example.demo.repositories;

import com.example.demo.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoList,Long> {

}
