package com.chklab.lifecycle;

import com.chklab.store.TodoListStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifeCycler implements StoreLifeCycle {

    private final TodoListStore todoListStore;

    public StoreLifeCycler(TodoListStore todoListStore) {
        this.todoListStore = todoListStore;
    }

    @Override
    public TodoListStore requestTodoListStore() {
        return this.todoListStore;
    }
}
