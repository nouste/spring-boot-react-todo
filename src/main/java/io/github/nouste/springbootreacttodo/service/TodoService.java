package io.github.nouste.springbootreacttodo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.nouste.springbootreacttodo.dto.TodoDto;
import io.github.nouste.springbootreacttodo.mapper.TodoMapper;
import io.github.nouste.springbootreacttodo.model.Todo;
import io.github.nouste.springbootreacttodo.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.toEntity(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        return TodoMapper.toDto(savedTodo);
    }

    public TodoDto getTodoById(Long id) {
        return todoRepository.findById(id)
                .map(TodoMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
    }

    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(TodoMapper::toDto)
                .collect(Collectors.toList());
    }

    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));

        existingTodo.setTitle(todoDto.title());
        existingTodo.setDescription(todoDto.description());
        existingTodo.setCompleted(todoDto.completed());

        Todo updatedTodo = todoRepository.save(existingTodo);
        return TodoMapper.toDto(updatedTodo);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found with id: " + id);
        }

        todoRepository.deleteById(id);
    }
}
