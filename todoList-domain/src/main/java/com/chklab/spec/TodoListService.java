package com.chklab.spec;


import com.chklab.entity.Todo;

import java.util.List;

public interface TodoListService {

    List<Todo> findTodoList();
    Todo findBySeq(Long seq);
    Todo registerTodo(Todo todo);
    Todo modifyTodo(Todo todo);
    void removeTodo(Long seq);

    Todo updateStatus(Long seq);

    List<Todo> findTodoListByPaging(int pageNumber, int pageSize, String status, String orderBy);

}
