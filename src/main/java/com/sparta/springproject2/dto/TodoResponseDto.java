package com.sparta.springproject2.dto;

import lombok.Getter;
import com.sparta.springproject2.entity.*;
import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private Long todoId;
    private String username;
    private String todoTitle;
    private String todoContents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
//    private boolean todoIsDone;

    public TodoResponseDto(Todo todo) {
        this.todoId = todo.getTodoId();
        this.username = todo.getUsername();
        this.todoTitle = todo.getTodoTitle();
        this.todoContents = todo.getTodoContents();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}
