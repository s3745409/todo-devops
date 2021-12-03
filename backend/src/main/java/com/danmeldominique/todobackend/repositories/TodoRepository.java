package com.danmeldominique.todobackend.repositories;

import com.danmeldominique.todobackend.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Override
    Optional<Todo> findById(Long aLong);

    @Override
    Iterable<Todo> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    boolean existsById(Long aLong);
}
