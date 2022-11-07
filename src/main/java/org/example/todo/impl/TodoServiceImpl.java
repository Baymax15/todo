package org.example.todo.impl;

import org.example.todo.dto.TodoDetailDto;
import org.example.todo.dto.TodoListDto;
import org.example.todo.model.Todo;
import org.example.todo.repository.TodoRepository;
import org.example.todo.service.TodoService;
import org.example.todo.util.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepo;

    @Override
    public TodoDetailDto createTodo(TodoDetailDto detailDto) {
        Todo todo = todoRepo.save(TodoMapper.fromDetailDto(detailDto));
        return TodoMapper.toDetailDto(todo);
    }

    @Override
    public List<TodoListDto> getAllTodo() {
        return ((List<Todo>) todoRepo.findAll()).stream()
                .map(TodoMapper::toListDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDetailDto getTodoById(Long id) {
        return todoRepo.findById(id)
                .map(TodoMapper::toDetailDto)
                .orElseThrow(() -> new RuntimeException("No Todo with id: " + id));
    }

    @Override
    public TodoDetailDto updateTodo(Long id, TodoDetailDto detailDto) {
        Todo todo = todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Todo with id: " + id));

        if (detailDto.getTitle() != null)
            todo.setTitle(detailDto.getTitle());
        if (detailDto.getDescription() != null)
            todo.setDescription(detailDto.getDescription());

        return TodoMapper.toDetailDto(todoRepo.save(todo));
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepo.deleteById(id);
    }
}
