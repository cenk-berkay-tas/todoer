package com.cenktas.todoer.controllers;

import com.cenktas.todoer.model.ErrorDetails;
import com.cenktas.todoer.model.TodoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoControllerAdvice {
    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorDetails> TodoNotFoundExceptionHandler() {
        ErrorDetails e = new ErrorDetails("Todo with given ID not found.");
        return ResponseEntity.badRequest().body(e);
    }
}
