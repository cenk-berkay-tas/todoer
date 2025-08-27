package com.cenktas.todoer;

import com.cenktas.todoer.controllers.TodoController;
import com.cenktas.todoer.model.*;
import com.cenktas.todoer.services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTests {
    @Mock
    private TodoService mockService;

    @InjectMocks
    private TodoController todoController;

    @Test
    public void getTodoHappyFlow() {
        long id = 1L;
        Todo todo = new Todo("Test");
        todo.setId(id);
        given(mockService.getTodo(id)).willReturn(todo);

        ResponseEntity<Todo> result = todoController.getTodo(id);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(todo, result.getBody());
        verify(mockService).getTodo(id);
    }

    @Test
    public void getTodoBadFlow() {
        long id = 1L;
        given(mockService.getTodo(id)).willThrow(TodoNotFoundException.class);

        assertThrows(TodoNotFoundException.class, () -> todoController.getTodo(id));
    }

    @Test
    public void newTodoTest() {
        long id = 1L;
        TodoRequest todoRequest = new TodoRequest("Test");
        Todo todo = new Todo("Test");
        todo.setId(id);
        given(mockService.createTodo(todoRequest)).willReturn(todo);

        ResponseEntity<Todo> result = todoController.newTodo(todoRequest);

        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(todo, result.getBody());
        verify(mockService).createTodo(todoRequest);
    }

    @Test
    public void updateTodoTest() {
        long id = 1L;
        Todo todo = new Todo("Test");
        todo.setId(id);
        Todo updatedTodo = new Todo("Test");
        updatedTodo.setId(id);
        updatedTodo.setStatus(Status.DONE);
        given(mockService.updateTodo(id, Status.DONE)).willReturn(updatedTodo);

        ResponseEntity<Todo> result = todoController.updateTodo(id, new StatusUpdate(Status.DONE));

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(updatedTodo, result.getBody());
        verify(mockService).updateTodo(id, Status.DONE);
    }

    @Test
    public void updateTodoBadFlow() {
        long id = 1L;

        given(mockService.updateTodo(id, Status.DONE)).willThrow(TodoNotFoundException.class);

        assertThrows(TodoNotFoundException.class, ()->todoController.updateTodo(id, new StatusUpdate(Status.DONE)));
    }
}
