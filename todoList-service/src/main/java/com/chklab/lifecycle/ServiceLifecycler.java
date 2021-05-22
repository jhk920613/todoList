package com.chklab.lifecycle;

import com.chklab.spec.TodoListService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifeCycle {

    private final TodoListService todoListService;

    public ServiceLifecycler(TodoListService todoListService) {
        this.todoListService = todoListService;
    }


    @Override
    public TodoListService requestTodoListService() {
        return this.todoListService;
    }
}
