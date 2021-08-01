package com.chklab.logic;

import com.chklab.entity.Todo;
import com.chklab.lifecycle.StoreLifeCycle;
import com.chklab.spec.TodoListService;
import com.chklab.store.TodoListStore;

import java.util.List;

public class TodoListLogic implements TodoListService {

    private final TodoListStore todoListStore;

    public TodoListLogic(StoreLifeCycle storeLifeCycle) {
        this.todoListStore = storeLifeCycle.requestTodoListStore();
    }

    @Override
    public List<Todo> findTodoList() {
        return this.todoListStore.retrieveTodoList();
    }

    @Override
    public Todo findBySeq(Long seq) {
        return this.todoListStore.retrieveTodo(seq);
    }

    @Override
    public Todo registerTodo(Todo todo) {
        todo.setStatus("F");
        return this.todoListStore.createTodo(todo);
    }

    @Override
    public Todo modifyTodo(Todo todo) {
        return this.todoListStore.updateTodo(todo);
    }

    @Override
    public void removeTodo(Long seq) {
        this.todoListStore.deleteTodo(seq);
    }

    @Override
    public Todo updateStatus(Long seq) {
        Todo todo = this.todoListStore.retrieveTodo(seq);

        if("T".equals(todo.getStatus())) {
            todo.setStatus("F");
        } else {
            todo.setStatus("T");
        }

        return this.todoListStore.updateTodo(todo);
    }

    @Override
    public List<Todo> findTodoListByPaging(int pageNumber, int pageSize, String status, String orderBy) {
        return this.todoListStore.retrieveTodoListByPaging(pageNumber,pageSize, status, orderBy);
    }
}
