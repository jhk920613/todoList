package com.chklab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApp {

    public static void main(String[] args) {
        // 스프링 부트 프로젝트를 시작한다는 명시
        // Start 컨트롤러 생성
        SpringApplication.run(TodoListApp.class, args);
    }

}
