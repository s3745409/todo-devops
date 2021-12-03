package com.danmeldominique.todobackend.services;

import com.danmeldominique.todobackend.models.Todo;
import com.danmeldominique.todobackend.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo create(Todo todo){
        return todoRepository.save(todo);
    }

    public boolean deleteById(Long id){
        todoRepository.deleteById(id);
        boolean todoExists = todoRepository.existsById(id);
        if(todoExists){
            return false;
        }
        return true;
    }

    public Iterable<Todo> getAll(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getItemById(Long id){
        return todoRepository.findById(id);
    }

}
