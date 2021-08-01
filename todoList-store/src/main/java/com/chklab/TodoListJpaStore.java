package com.chklab;

import com.chklab.entity.Todo;
import com.chklab.jpo.TodoJpo;
import com.chklab.repository.TodoListRepository;
import com.chklab.store.TodoListStore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoListJpaStore implements TodoListStore {

    private final TodoListRepository todoListRepository;

    public TodoListJpaStore(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<Todo> retrieveTodoList() {
        List<TodoJpo> todoJpoList = this.todoListRepository.findAll();

        return TodoJpo.toDomains(todoJpoList);
    }

    @Override
    public Todo retrieveTodo(Long seq) {
        Optional<TodoJpo> bySeq = this.todoListRepository.findBySeq(seq);
        System.out.println(bySeq.isPresent());
        return bySeq.map(TodoJpo::toDomain).orElse(null);
    }

    @Override
    public Todo createTodo(Todo todo) {
        TodoJpo todoJpo = new TodoJpo(todo);

        return this.todoListRepository.save(todoJpo).toDomain();
    }

    @Override
    public Todo updateTodo(Todo todo) {
        TodoJpo todoJpo = new TodoJpo(todo);

        return this.todoListRepository.save(todoJpo).toDomain();
    }

    @Override
    public void deleteTodo(Long seq) {
        this.todoListRepository.deleteById(seq);
    }

    @Override
    public List<Todo> retrieveTodoListByPaging(int pageNumber, int pageSize, String status, String orderBy) {
        Page<TodoJpo> jpos = this.todoListRepository.findByStatusStartingWith(
                PageRequest.of(pageNumber, pageSize, Sort.by(orderBy)),
                status
        );

        return jpos.map(TodoJpo::toDomain).toList();
    }
}
