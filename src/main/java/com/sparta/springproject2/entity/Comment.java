package com.sparta.springproject2.entity;

import com.sparta.springproject2.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "name", nullable = false)
    private String name; //userID로 해야하나?

    @Column(name = "comment_contents", nullable = false, length = 500)
    private String commentContents;

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Todo todo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;



    public Comment(CommentRequestDto requestDto) {
//        this.commentId = requestDto.getCommentId();
        this.name = requestDto.getName();
        this.commentContents = requestDto.getCommentContents();
//        this.todo = requestDto.getTodo();
    }

    public void update(CommentRequestDto requestDto) {
        this.commentContents = requestDto.getCommentContents();
    }
}
