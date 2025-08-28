package com.cenktas.todoer.services;

import com.cenktas.todoer.model.Status;
import com.cenktas.todoer.model.Todo;
import com.cenktas.todoer.model.TodoNotFoundException;
import com.cenktas.todoer.model.TodoRequest;
import com.cenktas.todoer.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public Iterable<Todo> batchCreateTodos(List<TodoRequest> todoRequests) {
        Iterable<Todo> todos = todoRequests.stream()
                .map(s -> new Todo(s.text()))
                .toList();
        return todoRepository.saveAll(todos);
    }

    public Todo updateTodo(long id, Status status) {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todo.setStatus(status);
        todo.setLastUpdatedAt(LocalDateTime.now());
        todoRepository.save(todo);
        return todo;
    }

    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    public void deleteTodo(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todoRepository.delete(todo);
    }

}
