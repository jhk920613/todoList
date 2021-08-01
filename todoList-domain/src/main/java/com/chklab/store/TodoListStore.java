package com.chklab.store;


import com.chklab.entity.Todo;

import java.util.List;

public interface TodoListStore {

    List<Todo> retrieveTodoList();
    Todo retrieveTodo(Long seq);
    Todo createTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(Long seq);

    List<Todo> retrieveTodoListByPaging(int pageNumber, int pageSize, String status, String orderBy);
}
