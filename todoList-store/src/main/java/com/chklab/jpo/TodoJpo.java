package com.chklab.jpo;

import com.chklab.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TODO_LIST")
public class TodoJpo {

    @Id
    @Column(name = "SEQ", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(name = "STATUS", nullable = false)
    private String status;
    @Column(name = "TODO_COMMENT", nullable = false)
    private String todoComment;

    public TodoJpo(Todo todo) {
        BeanUtils.copyProperties(todo, this);
    }

    public Todo toDomain() {
        Todo todo = new Todo();
        BeanUtils.copyProperties(this, todo);

        return todo;
    }

    public static List<Todo> toDomains(Iterable<TodoJpo> apiTestJpos) {
        return StreamSupport.stream(apiTestJpos.spliterator(), false)
                .map(TodoJpo::toDomain)
                .collect(Collectors.toList());
    }

}
