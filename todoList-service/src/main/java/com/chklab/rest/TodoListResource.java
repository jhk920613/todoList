package com.chklab.rest;


import com.chklab.entity.Todo;
import com.chklab.lifecycle.ServiceLifeCycle;
import com.chklab.spec.TodoListService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/todoList")
public class TodoListResource {

    private final TodoListService todoListService;

    public TodoListResource(ServiceLifeCycle serviceLifeCycle) {
        this.todoListService = serviceLifeCycle.requestTodoListService();
    }


    @ResponseBody
    @GetMapping(path = "/findAll")
    List<Todo> findTodoList() {
        return this.todoListService.findTodoList();
    }

    @ResponseBody
    @GetMapping(path = "/{seq}")
    Todo findBySeq(@PathVariable("seq") Long seq) {
        return this.todoListService.findBySeq(seq);
    }

    @ResponseBody
    @PostMapping
    Todo registerTodo(@RequestBody Todo todo) {
        return this.todoListService.registerTodo(todo);
    }

    @ResponseBody
    @PutMapping
    Todo modifyTodo(@RequestBody Todo todo) {
        return this.todoListService.modifyTodo(todo);
    }

    @ResponseBody
    @DeleteMapping(path = "/{seq}")
    void removeTodo(@PathVariable("seq") Long seq) {
        this.todoListService.removeTodo(seq);
    }

    @PutMapping(value = "/{seq}")
    Todo updateStatus(@PathVariable("seq") Long seq) {
        return this.todoListService.updateStatus(seq);
    }

    @GetMapping(value = "/paging/{pageNumber}/{pageSize}/{status}/{orderBy}")
    public List<Todo> findTodoListByPaging(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize, @PathVariable("status") String status, @PathVariable("orderBy") String orderBy) {
        return this.todoListService.findTodoListByPaging(pageNumber, pageSize, status, orderBy);
    }
}
