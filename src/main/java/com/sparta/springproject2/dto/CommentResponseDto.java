package com.sparta.springproject2.dto;

import com.sparta.springproject2.entity.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long commentId;
//    private String username;
    private Long todoId;
    private String commentContents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
//        this.username = comment.getUsername();
        this.todoId = comment.getTodo().getTodoId();
        this.commentContents = comment.getCommentContents();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
