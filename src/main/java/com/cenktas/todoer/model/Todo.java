package com.cenktas.todoer.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Objects;


public class Todo {
    @Id
    private long id;
    private String text;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    public Todo(String text) {
        this.text = text;
        this.createdAt = LocalDateTime.now();
        this.lastUpdatedAt = createdAt;
        this.status = Status.TODO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime last_updated) {
        this.lastUpdatedAt = last_updated;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Todo todo)) return false;
        return id == todo.id && Objects.equals(text, todo.text) && status == todo.status && Objects.equals(createdAt, todo.createdAt) && Objects.equals(lastUpdatedAt, todo.lastUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, status, createdAt, lastUpdatedAt);
    }
}
