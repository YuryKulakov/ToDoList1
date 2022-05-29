package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="todolist")
public class ToDoList {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private boolean done;
    private Date dateNow;
    private int priority;

    @Column(name = "username")
    private String username;
}
