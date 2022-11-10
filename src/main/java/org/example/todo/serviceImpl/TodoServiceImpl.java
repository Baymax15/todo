package org.example.todo.serviceImpl;

import org.example.todo.dao.TodoDao;
import org.example.todo.dto.TodoDetailDto;
import org.example.todo.dto.TodoListDto;
import org.example.todo.mappers.TodoMapper;
import org.example.todo.model.Todo;
import org.example.todo.service.TodoService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private final Jdbi jdbi;

    public TodoServiceImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
        jdbi.useExtension(TodoDao.class, TodoDao::createTodoTable);
    }

    @Override
    public TodoDetailDto createTodo(TodoDetailDto dto) {
        Long id = jdbi.withExtension(TodoDao.class, dao -> dao.create(TodoMapper.fromDetailDto(dto).getTodo()));
        return getTodoById(id);
    }

    @Override
    public List<TodoListDto> getAllTodo() {
        return jdbi.withExtension(TodoDao.class, dao -> dao.getTodos().stream()
                .map(todo -> new TodoMapper(todo).toListDto())
                .collect(Collectors.toList()));
    }

    @Override
    public TodoDetailDto getTodoById(Long id) {
        return jdbi.withExtension(TodoDao.class, dao -> new TodoMapper(dao.getTodo(id)).toDetailDto());
    }

    @Override
    public TodoDetailDto updateTodo(Long id, TodoDetailDto dto) {
        Todo todo = jdbi.withExtension(TodoDao.class, dao -> dao.getTodo(id));
        jdbi.useExtension(TodoDao.class, dao -> dao.updateTodo(id, new TodoMapper(todo).updateWith(dto)));
        return getTodoById(id);
    }

    @Override
    public void deleteTodo(Long id) {
        jdbi.useExtension(TodoDao.class, dao -> dao.deleteTodo(id));
    }
}
