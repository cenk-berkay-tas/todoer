package com.cenktas.todoer.repositories;

import com.cenktas.todoer.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
