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
    public List<Todo> registerTodo(Todo todo) {
        todo.setStatus("F");
        this.todoListStore.createTodo(todo);
        return this.todoListStore.retrieveTodoList();
    }

    @Override
    public List<Todo> modifyTodo(Todo todo) {
        this.todoListStore.updateTodo(todo);
        return this.todoListStore.retrieveTodoList();
    }

    @Override
    public List<Todo> removeTodo(Long seq) {
        this.todoListStore.deleteTodo(seq);
        return this.todoListStore.retrieveTodoList();
    }

    @Override
    public List<Todo> updateStatus(Long seq) {
        Todo todo = this.todoListStore.retrieveTodo(seq);

        if("T".equals(todo.getStatus())) {
            todo.setStatus("F");
        } else {
            todo.setStatus("T");
        }

        this.todoListStore.updateTodo(todo);
        return this.todoListStore.retrieveTodoList();
    }
}
