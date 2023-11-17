package com.sparta.springproject2.controller;

import com.sparta.springproject2.dto.CommentRequestDto;
import com.sparta.springproject2.dto.CommentResponseDto;
import com.sparta.springproject2.dto.CommentRequestDto;
import com.sparta.springproject2.dto.CommentResponseDto;
import com.sparta.springproject2.service.CommentService;
import com.sparta.springproject2.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    // CREATE
    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    // READ
    @GetMapping
    public List<CommentResponseDto> getComments() {
        return commentService.getComments();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Long deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }


}
