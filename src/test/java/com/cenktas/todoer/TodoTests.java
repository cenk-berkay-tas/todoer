package com.cenktas.todoer;


import com.cenktas.todoer.model.Status;
import com.cenktas.todoer.model.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTests {
    @Test
    public void TodoIsCreatedCorrectly() {
        String todoText = "This is a todo";
        Todo todo = new Todo(todoText);

        assertEquals(todoText, todo.getText());
        assertEquals(todo.getCreatedAt(), todo.getLastUpdatedAt());
        assertEquals(Status.TODO, todo.getStatus());

    }
}
