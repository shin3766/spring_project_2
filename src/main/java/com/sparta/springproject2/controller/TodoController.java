package com.sparta.springproject2.controller;

import com.sparta.springproject2.dto.TodoRequestDto;
import com.sparta.springproject2.dto.TodoResponseDto;
import com.sparta.springproject2.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping
    public List<TodoResponseDto> getTodos() {
        return todoService.getTodos();
    }

    @PutMapping("/{id}")
    public Long updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }
}
