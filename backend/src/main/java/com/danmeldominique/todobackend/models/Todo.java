package com.danmeldominique.todobackend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date createdOn;

    @PrePersist
    protected void onCreate(){
        this.createdOn = new Date();
    }


}