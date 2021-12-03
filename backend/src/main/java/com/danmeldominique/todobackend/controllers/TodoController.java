package com.danmeldominique.todobackend.controllers;

import com.danmeldominique.todobackend.models.Todo;
import com.danmeldominique.todobackend.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        // Get all _todo items
        List<Todo> todos = (List<Todo>) todoService.getAll();
        if(todos.isEmpty() || !todos.isEmpty()){
            return new ResponseEntity<>(todos, HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong. Try again later.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        // Get a single _todo item by ID
        Optional<Todo> todo = todoService.getItemById(id);
        if(todo.isPresent()){
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong. Try again later.", HttpStatus.BAD_REQUEST);
    }


    @PostMapping("")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo, BindingResult result) {
        // Create a single _todo item

        if(result.hasErrors()){
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        todoService.create(todo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(name = "id") Long id){
        Map<String, String> output = new HashMap<>();
        boolean success = todoService.deleteById(id);
        if(success) {
            output.put("success", "true");
            output.put("Message", "Listing has been successfully deleted.");
            return new ResponseEntity<>(output, HttpStatus.OK);
        }
        output.put("success", "false");
        output.put("Message", "Listing has not been deleted");
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
