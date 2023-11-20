package com.sparta.springproject2.entity;

import com.sparta.springproject2.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "todo")
@NoArgsConstructor
public class Todo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "todo_title", nullable = false)
    private String todoTitle;
    @Column(name = "todo_contents", nullable = false, length = 500)
    private String todoContents;
    @OneToMany(mappedBy = "todo", cascade = CascadeType.PERSIST)
    private List<Comment> commentList = new ArrayList<>();
    @Column
    private boolean todoIsDone = false;

    public Todo(TodoRequestDto requestDto) {
        //username은 나중에 jwt로 처리
        this.name = requestDto.getName();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContents = requestDto.getTodoContents();
//        this.todoIsDone = requestDto.getTodoIsDone();
    }

    public void update(TodoRequestDto requestDto) {
//        this.todoTitle = requestDTO.getTitle();
        this.name = requestDto.getName();
        this.todoTitle = requestDto.getTodoTitle();
        this.todoContents = requestDto.getTodoContents();
//        this.todoDate = requestDTO.getLocalDate();
//        this.todoIsDone = requestDTO.getTodoisDone();
    }

    public void addCommentList(Comment comment) {
        this.commentList.add(comment);
        comment.setTodo(this);
    }
}