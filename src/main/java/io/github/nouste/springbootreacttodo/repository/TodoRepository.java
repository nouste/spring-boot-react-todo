package io.github.nouste.springbootreacttodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.nouste.springbootreacttodo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
