package com.chklab.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {

    private Long seq;
    private String status;
    private String todoComment;

}
