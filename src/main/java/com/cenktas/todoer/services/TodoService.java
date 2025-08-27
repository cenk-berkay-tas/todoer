package com.cenktas.todoer.services;

import com.cenktas.todoer.model.Status;
import com.cenktas.todoer.model.Todo;
import com.cenktas.todoer.model.TodoNotFoundException;
import com.cenktas.todoer.model.TodoRequest;
import com.cenktas.todoer.repositories.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(long id) {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }
    public Todo createTodo(TodoRequest todoRequest) {
        return todoRepository.save(new Todo(todoRequest.text()));
    }

    public Todo updateTodo(long id, Status status) {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todo.setStatus(status);
        todoRepository.save(todo);
        return todo;
    }
}
