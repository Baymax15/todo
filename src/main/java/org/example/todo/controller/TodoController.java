package org.example.todo.controller;

import org.example.todo.dto.TodoDetailDto;
import org.example.todo.dto.TodoListDto;
import org.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public TodoDetailDto createTodo(@RequestBody TodoDetailDto detailDto) {
        return service.createTodo(detailDto);
    }

    @GetMapping
    public List<TodoListDto> getTodos() {
        return service.getAllTodo();
    }

    @GetMapping("/{id}")
    public TodoDetailDto getTodoById(@PathVariable(value = "id") Long id) {
        return service.getTodoById(id);
    }

    @PutMapping("/{id}")
    public TodoDetailDto updateTodo(@PathVariable(value = "id") Long id, @RequestBody TodoDetailDto detailDto) {
        return service.updateTodo(id, detailDto);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable(value = "id") Long id) {
        service.deleteTodo(id);
        return "Deleted Todo with id: " + id;
    }
}
