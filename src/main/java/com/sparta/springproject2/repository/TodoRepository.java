package com.sparta.springproject2.repository;

import com.sparta.springproject2.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByOrderByModifiedAtDesc();
}
