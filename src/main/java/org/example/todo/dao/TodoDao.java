package org.example.todo.dao;

import org.example.todo.model.Todo;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import java.util.List;

public interface TodoDao {
    @Transaction
    @SqlUpdate("create table if not exists todos " +
            "(id bigint not null generated always as identity," +
            " title varchar(100) not null unique," +
            " description varchar(500))")
    void createTodoTable();

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("insert into todos (title, description) values (:title, :description)")
    Long create(@BindBean Todo todo);

    @SqlQuery("select * from todos;")
    @RegisterBeanMapper(Todo.class)
    List<Todo> getTodos();

    @SqlQuery("select * from todos where id=:id")
    @RegisterBeanMapper(Todo.class)
    Todo getTodo(Long id);

    @Transaction
    @SqlUpdate("update todos set title=:title, description=:description where id=:id")
    void updateTodo(@Bind("id") Long id, @BindBean Todo todo);

    @Transaction
    @SqlUpdate("delete from todos where id=:id")
    void deleteTodo(Long id);
}
