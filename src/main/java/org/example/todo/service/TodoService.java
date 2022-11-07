package org.example.todo.service;

import org.example.todo.dto.TodoDetailDto;
import org.example.todo.dto.TodoListDto;

import java.util.List;


public interface TodoService {
    TodoDetailDto createTodo(TodoDetailDto detailDto);

    List<TodoListDto> getAllTodo();

    TodoDetailDto getTodoById(Long id);

    TodoDetailDto updateTodo(Long id, TodoDetailDto detailDto);

    void deleteTodo(Long id);
}
