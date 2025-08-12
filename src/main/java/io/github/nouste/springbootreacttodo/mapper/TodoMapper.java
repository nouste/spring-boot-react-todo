package io.github.nouste.springbootreacttodo.mapper;

import io.github.nouste.springbootreacttodo.dto.TodoDto;
import io.github.nouste.springbootreacttodo.model.Todo;

public class TodoMapper {
    public static TodoDto toDto(Todo todo) {
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
    }

    public static Todo toEntity(TodoDto todoDto) {
        return new Todo(todoDto.id(), todoDto.title(), todoDto.description(), todoDto.completed());
    }
}
