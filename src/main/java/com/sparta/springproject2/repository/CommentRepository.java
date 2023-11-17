package com.sparta.springproject2.repository;

import com.sparta.springproject2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();

}
