package org.example.todo.mappers;

import org.example.todo.dto.TodoDetailDto;
import org.example.todo.dto.TodoListDto;
import org.example.todo.model.Todo;

public class TodoMapper {
    private final Todo todo;

    public TodoMapper(Todo todo) {
        this.todo = todo;
    }

    public static TodoMapper fromDetailDto(TodoDetailDto dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        return new TodoMapper(todo);
    }

    public Todo getTodo() {
        return todo;
    }

    public TodoDetailDto toDetailDto() {
        TodoDetailDto dto = new TodoDetailDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        return dto;
    }

    public TodoListDto toListDto() {
        TodoListDto dto = new TodoListDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        return dto;
    }

    public Todo updateWith(TodoDetailDto dto) {
        if (dto.getTitle() != null) todo.setTitle(dto.getTitle());
        if (dto.getDescription() != null) todo.setDescription(dto.getDescription());
        return todo;
    }
}
