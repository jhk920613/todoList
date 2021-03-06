package com.chklab.repository;

import com.chklab.jpo.TodoJpo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TodoListRepository extends JpaRepository<TodoJpo, Long> {

    Optional<TodoJpo> findBySeq(Long seq);

    Page<TodoJpo> findByStatusStartingWith(Pageable pageable, String todoComment);

}
