package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class ToDoList {
    @Id
    private long id;
    private String title;
    private boolean done;
    private Date dateNow;
    private int priority;

    @Column(name = "username")
    private String name;
}
