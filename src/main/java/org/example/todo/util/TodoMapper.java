package org.example.todo.util;

import org.example.todo.dto.TodoDetailDto;
import org.example.todo.dto.TodoListDto;
import org.example.todo.model.Todo;

public class TodoMapper {
    public static Todo fromDetailDto(TodoDetailDto dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        return todo;
    }

    public static TodoListDto toListDto(Todo todo) {
        TodoListDto dto = new TodoListDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        return dto;
    }

    public static TodoDetailDto toDetailDto(Todo todo) {
        TodoDetailDto dto = new TodoDetailDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        return dto;
    }
}
