package com.cenktas.todoer;

import com.cenktas.todoer.model.Status;
import com.cenktas.todoer.model.Todo;
import com.cenktas.todoer.model.TodoNotFoundException;
import com.cenktas.todoer.repositories.TodoRepository;
import com.cenktas.todoer.services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTests {
    @Mock
    private TodoRepository mockRepository;

    @InjectMocks
    private TodoService service;

    @Test
    public void getTodoTest() {
        Todo expectedTodo = new Todo("test");
        long id = expectedTodo.getId();
        given(mockRepository.findById(id)).willReturn(Optional.of(expectedTodo));

        Todo todo = service.getTodo(id);

        assertEquals(todo, expectedTodo);
        verify(mockRepository).findById(id);
    }

    @Test
    public void getTodoFailTest() {
        long id = 1L;
        given(mockRepository.findById(id)).willReturn(Optional.empty());

        assertThrows(TodoNotFoundException.class, () -> service.getTodo(id));
    }

    @Test
    public void todoCanUpdate() {
        Todo todo = new Todo("test");
        todo.setId(1L);
        given(mockRepository.findById(1L)).willReturn(Optional.of(todo));

        Todo updatedTodo = service.updateTodo(1L, Status.DONE);

        assertEquals(Status.DONE, todo.getStatus());
        assertEquals(todo, updatedTodo);
        verify(mockRepository).save(todo);
    }

    @Test
    public void TodoCanUpdateFail() {
        long id = 1L;
        given(mockRepository.findById(id)).willReturn(Optional.empty());

        assertThrows(TodoNotFoundException.class, () -> service.updateTodo(id, Status.DONE));
    }
    // missing test for getAllTodos() (the method does nothing expect call repository.findAll())
}
