package com.chklab.spec;


import com.chklab.entity.Todo;

import java.util.List;

public interface TodoListService {

    List<Todo> findTodoList();
    Todo findBySeq(Long seq);
    List<Todo> registerTodo(Todo todo);
    List<Todo> modifyTodo(Todo todo);
    List<Todo> removeTodo(Long seq);

    List<Todo> updateStatus(Long seq);

}
