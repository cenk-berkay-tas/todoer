package com.cenktas.todoer.controllers;

import com.cenktas.todoer.model.StatusUpdate;
import com.cenktas.todoer.model.Todo;
import com.cenktas.todoer.model.TodoRequest;
import com.cenktas.todoer.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/v1/todos")
    public ResponseEntity<Iterable<Todo>> getAllTodos() {
        Iterable<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }

    @GetMapping("/api/v1/todos/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodo(id));
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<Todo> newTodo(@RequestBody TodoRequest todoRequest) {
        Todo todo = todoService.createTodo(todoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @PatchMapping("/api/v1/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable long id, @RequestBody StatusUpdate s) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(id, s.status()));
    }
}
