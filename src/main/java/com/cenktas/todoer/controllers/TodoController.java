package com.cenktas.todoer.controllers;

import com.cenktas.todoer.model.Status;
import com.cenktas.todoer.model.StatusUpdate;
import com.cenktas.todoer.model.Todo;
import com.cenktas.todoer.services.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/api/v1/todos")
    private void newTodo(@RequestBody Todo todo) {
        todoService.createTodo(todo);
    }

    @GetMapping("/api/v1/todos")
    private Iterable<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/api/v1/todos/{id}")
    private Todo getTodo(@PathVariable long id) {
        return todoService.getTodo(id);
    }
    @PatchMapping("/api/v1/todos/{id}")
    private Todo updateTodo(@PathVariable long id, @RequestBody StatusUpdate s) {
        return todoService.updateTodo(id, s.status());
    }
}
